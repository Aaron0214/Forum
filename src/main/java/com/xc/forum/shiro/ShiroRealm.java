/**
 * 
 */
package com.xc.forum.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author chenlf
 * 
 *         2014-3-24
 */
public class ShiroRealm extends AuthorizingRealm {

	/*@Autowired
	private UserMapper userMapper;

	@Autowired
	private FunctionMapper functionMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// 根据用户配置用户与权限
		if (principals == null) {
			throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
		}
		String name = (String) getAvailablePrincipal(principals);
		if (name != null) {
//			User user = userMapper.selectByName(name);
//			if (user != null) {
//				List<Integer> roleIds = userRoleMapper.selectRolesByUserId(user.getId());
				List<String> functionList = null;
//				if(CollectionUtils.isNotEmpty(roleIds)){
//					functionList = functionMapper.selectFunctionList(roleIds);
//				}
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				if (null != functionList) {
					info.addStringPermissions(functionList);
				} else {
					functionList = new ArrayList<String>();
					info.addStringPermissions(functionList);
				}
				return info;
			} else {
				throw new AuthorizationException();
			}
//		} else {
//			throw new AuthorizationException();
//		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org
	 * .apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		User user = userMapper.selectByUserName(token.getUsername());
//		if (user == null) {
//			throw new AuthorizationException();
//		}
		String password = "";
		for(char str : token.getPassword()){
			password += str;
		}
		SimpleAuthenticationInfo info = null;
//		if (user.getUsername().equals(token.getUsername()) && password.equals(user.getPassword())) {
//			info = new SimpleAuthenticationInfo(user.getName(),user.getPassword(), getName());
//		}else{
//			throw new IncorrectCredentialsException();
//		}
		return info;
	}
}