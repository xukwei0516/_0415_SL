package com.sy.mapper.common;



import com.sy.model.common.Authority;

import java.util.List;

/**
 * AuthorityMapper
 *
 */
public interface AuthorityMapper {
	/**
	 * 根据RoleId查询其对应的所有权限
	 * @return
	 */
	public List<Authority> getList(Authority authority) throws Exception;
	/**
	 * 根据RoleId和FunctionId精确查询单个权限
	 * @param authority
	 * @return
	 * @throws Exception
	 */
	public Authority getAuthority(Authority authority) throws Exception;
	/**
	 * 新增一条权限
	 * @param authority
	 * @return
	 */
	public int addAuthority(Authority authority) throws Exception;
	/**
	 * 删除一条权限
	 * @param authority
	 * @return
	 */
	public int modifyAuthority(Authority authority) throws Exception;
	/**
	 *  更新权限
	 * @param authority
	 * @return
	 */
	public int deleteAuthority(Authority authority) throws Exception;
}
