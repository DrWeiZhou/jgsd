package edu.puxianxingyuan.jgsd.base.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.puxianxingyuan.jgsd.base.service.BaseService;

/**
 * 继承该类可以满足普通同步请求及ajax异步请求的CRUD操作，方法结尾包含JSON的方法是供ajax请求使用的
 * @author 周炜
 * @param <T>
 */
@Controller
@Scope("prototype")
@ParentPackage("json-default")
/*
 * By default properties defined on base classes of the "root" object won't be serialized, to serialize properties in all base classes (up to Object) set "ignoreHierarchy" to false in the JSON result:
<result type="json">
  <param name="ignoreHierarchy">false</param>
</result>
 */
@Results({ @Result(name="json",type="json",params={"root","action","ignoreHierarchy","false"}),
/* 子类需要重新定义重写以下信息
 @Results({
	@Result(name="to_create",location="/admin/newsManage/TestNewsDetail.jsp"),//创建时显示页面
	@Result(name="to_modify",location="/admin/newsManage/TestNewsDetail.jsp"),//修改时显示页面
	@Result(name="to_show",location="/admin/newsManage/TestNewsDetail.jsp"),//单条信息展示
	@Result(name="to_showList",location="/admin/newsManage/TestNewsDetail.jsp")//多条信息列表页面
 })
*/
})

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	//以下三个参数用于页面分页参数，主要是供easyui的datagrid控件使用
	protected Integer page=1; //当前页码
	protected Integer total;//向页面传，共多少条
	protected Integer rows=10;//从页面传，每页条数
	
	
	/**
	 * 用于返回给页面的list，主要是供easyui的datagrid控件使用,该参数返回页面时json名字为rows，原rows属性不作为json返回
	 */
	protected List<T> list;
	
	Class entityClass;
	
	/**
	 * DataTransferObject,用于封装页面传过来的domain对象的字段,ModelDriven接口中使用的getModel方法的返回对象
	 * 页面输出值的对象使用EL格式为${dto.propName}
	 */
	protected T dto;
	
	
	/**
	 * action中的toTab根据传入的toWhere直接转到不同的jsp页面，而不进行任何页面数据的预处理，这比从起始页面直接跳转到目标页面的好处在对目标jsp页面进行了封装，实现了起始页面同目标页面的解耦
	 * 为了CRUD函数的输出路径不写死，可扩展，如果toWhere的形式为"!to_xxx"，则跳转至to_xxx
	 */
	protected String toWhere;
	
	protected Integer id;//用于页面向此action传值，该名字不能与dtoModel中的主键一样
	
	
	/**
	 * 子类重写该对象返回自定义的Service对象，该Service对象为具有基本CRUD的BaseService接口对象
	 * @return
	 */
	abstract protected BaseService getService(); 

	
	public BaseAction(){  
        Type superclass = this.getClass().getGenericSuperclass();  
        ParameterizedType type = (ParameterizedType) superclass;  
        Type[] args = type.getActualTypeArguments();  
        entityClass = (Class) ((null != args && args.length > 0) ? args[0]  
                : null);  
        try {  
            this.dto = (T) entityClass.newInstance();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
	
	
	/* 
	 * 实现ModelDriven接口方法
	 */
	@Override
	public T getModel() {
		return dto;
	}
	
	public String findAllJSON(){
		this.list = getService().findAllByPage(this.page,this.rows);
		this.total = (int)getService().findCount();
		return "json";
	}
	
	public String findAll(){
		this.list = getService().findAllByPage(this.page,this.rows);
		this.total = (int)getService().findCount();
		if(toWhere != null && toWhere.startsWith("!to_")){
			return toWhere.substring(1);
		}else{
			return "to_showList";
		}
	}
	
	public String findOneJSON(){
		this.dto = (T)getService().getById(id);
		return "json";
	}
	
	public String findOne(){
		this.dto = (T)getService().getById(id);
		if(toWhere != null && toWhere.startsWith("!to_")){
			return toWhere.substring(1);
		}else{
			return "to_show";
		}
	}
	
	public String findModifyJSON(){
		this.dto = (T)getService().getById(id);
		return "json";
	}
	
	public String findModify(){
		this.dto = (T)getService().getById(id);
		if(toWhere != null && toWhere.startsWith("!to_")){
			return toWhere.substring(1);
		}else{
			return "to_modify";
		}
	}
	
	public String deleteJSON(){
		getService().deleteById(id);
		return "json";
	}
	
	public String delete(){
		getService().deleteById(id);
		if(toWhere != null && toWhere.startsWith("!to_")){
			return toWhere.substring(1);
		}else{
			return "to_showList";
		}
	}
	
	public String saveJSON(){
		getService().save(dto);
		return "json";
	}
	
	public String save(){
		getService().save(dto);
		if(toWhere != null && toWhere.startsWith("!to_")){
			return toWhere.substring(1);
		}else{
			return "to_showList";
		}
	}
	
	public String updateJSON(){
		getService().updateByDTO(dto);
		return "json";
	}
	
	public String update(){
		getService().updateByDTO(dto);
		if(toWhere != null && toWhere.startsWith("!to_")){
			return toWhere.substring(1);
		}else{
			return "to_showList";
		}
	}
	
	public String saveAndUpdateJSON(){
		//判定dto的@id属性是否有值，没有的话save保存，有的话update
		this.getService().saveAndUpdate(dto);
		
		return "json";
	}
	
	
	public String saveAndUpdate(){
		//判定dto的@id属性是否有值，没有的话save保存，有的话update
		this.getService().saveAndUpdate(dto);
		
		if(toWhere != null && toWhere.startsWith("!to_")){
			return toWhere.substring(1);
		}else{
			return "to_showList";
		}
	}
	
	/**
	 * 此外该方法在创建记录时也可调用
	 * @return
	 */
	public String toTab(){
		return toWhere;
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	//rows不向页面序列化传输
	@JSON(serialize=false)
	public Integer getRows() {
		return rows;
	}


	public void setRows(Integer rows) {
		this.rows = rows;
	}

	
	/**
	 * @return list对象返回页面时的json属性名为rows，主要是供easyui的datagrid控件使用
	 */
	@JSON(name="rows")
	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}

	
	public T getDto() {
		return dto;
	}

	public void setDto(T dto) {
		this.dto = dto;
	}



	public String getToWhere() {
		return toWhere;
	}

	public void setToWhere(String toWhere) {
		this.toWhere = toWhere;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
