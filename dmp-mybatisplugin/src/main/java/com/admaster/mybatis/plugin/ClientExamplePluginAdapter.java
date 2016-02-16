package com.admaster.mybatis.plugin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.plexus.util.ReflectionUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;

public class ClientExamplePluginAdapter extends PluginAdapter{

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		List<Parameter> parameters = method.getParameters();
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * 根据主键删除");
		for (Parameter parameter : parameters) {
			method.addJavaDocLine(" * @param " +parameter.getName());
		}
		method.addJavaDocLine(" * @return 受影响条数");
		method.addJavaDocLine(" *");
		method.addJavaDocLine(" * " + MergeConstants.NEW_ELEMENT_TAG);
		method.addJavaDocLine(" */");
		return true;
	}

	public boolean clientInsertSelectiveMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		List<Parameter> parameters = method.getParameters();
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * 新增数据");
		for (Parameter parameter : parameters) {
			method.addJavaDocLine(" * @param " +parameter.getName());
		}
		method.addJavaDocLine(" * @return 受影响条数");
		method.addJavaDocLine(" *");
		method.addJavaDocLine(" * " + MergeConstants.NEW_ELEMENT_TAG);
		method.addJavaDocLine(" */");
		return true;
	}


	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		List<Parameter> parameters = method.getParameters();
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * 根据主键查询数据");
		for (Parameter parameter : parameters) {
			method.addJavaDocLine(" * @param " +parameter.getName());
		}
		method.addJavaDocLine(" * @return " );
		method.addJavaDocLine(" *");
		method.addJavaDocLine(" * " + MergeConstants.NEW_ELEMENT_TAG);
		method.addJavaDocLine(" */");
		return true;
	}


	public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		List<Parameter> parameters = method.getParameters();
		method.addJavaDocLine("/**");
		method.addJavaDocLine(" * 根据主键修改数据");
		for (Parameter parameter : parameters) {
			method.addJavaDocLine(" * @param " +parameter.getName());
		}
		method.addJavaDocLine(" * @return 受影响条数" );
		method.addJavaDocLine(" *");
		method.addJavaDocLine(" * " + MergeConstants.NEW_ELEMENT_TAG);
		method.addJavaDocLine(" */");
		return true;
	}

	

	public boolean clientCountByExampleMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientCountByExampleMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientDeleteByExampleMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientDeleteByExampleMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}



	public boolean clientInsertMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientInsertMethodGenerated(Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}



	public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientUpdateByExampleSelectiveMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientUpdateByExampleWithBLOBsMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientUpdateByExampleWithoutBLOBsMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}



	public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(
			Method method, Interface interfaze,
			IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(
			Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}


	public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method,
			Interface interfaze, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	
	@Override
	public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		List<IntrospectedColumn> keyColumns = introspectedTable.getPrimaryKeyColumns();
		if (!keyColumns.isEmpty() && keyColumns.size() > 1 && keyColumns.size() == introspectedTable.getAllColumns().size()) {
			updateParamOrResutType("parameterType", element, introspectedTable);
		}
		return true;
	}

	@Override
	public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		updateParamOrResutTypeByField("name", "resultType", "resultMap", element);
		updateParamOrResutType("resultType", element, introspectedTable);
		return true;
	}

	@Override
	public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		updateParamOrResutType("parameterType", element, introspectedTable);
		return true;
	}

	@Override
	public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		updateParamOrResutType("parameterType", element, introspectedTable);
		return true;
	}
	
	/**
	 * @param element
	 */
	private void updateParamOrResutTypeByField(String fieldName, Object value, String attrName, XmlElement element) {
		List<Attribute> attributes = element.getAttributes();
		for (Attribute attribute : attributes) {
			if (attrName.equals(attribute.getName())) {
				try {
					java.lang.reflect.Field field = ReflectionUtils.getFieldByNameIncludingSuperclasses(fieldName, attribute.getClass());
					field.setAccessible(true);
					field.set(attribute, value);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param element
	 */
	private void updateParamOrResutType(String attrName, XmlElement element, IntrospectedTable introspectedTable) {
		List<Attribute> attributes = element.getAttributes();
		for (Attribute attribute : attributes) {
			if (attrName.equals(attribute.getName())) {
				try {
					java.lang.reflect.Field field = ReflectionUtils.getFieldByNameIncludingSuperclasses("value", attribute.getClass());
					field.setAccessible(true);
					field.set(attribute, introspectedTable.getTableConfiguration().getDomainObjectName());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean sqlMapResultMapWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
//		updateParamOrResutType("type", element, introspectedTable);
//		return true;
		return false;
	}

	@Override
	public boolean sqlMapResultMapWithBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
//		updateParamOrResutType("type", element, introspectedTable);
//		return true;
		return false;
	}
	
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapUpdateByExampleSelectiveElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapUpdateByExampleWithBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapUpdateByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		return false;
	}



	public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapDeleteByExampleElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapInsertElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		return false;
	}

	public boolean sqlMapCountByExampleElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		return false;
	}
	

	/**
	 * 阻止生成Example类的操作
	 */
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return false;
	}
	
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	List<IntrospectedColumn> keyColumns = introspectedTable.getPrimaryKeyColumns();
		if (!keyColumns.isEmpty() && keyColumns.size() > 1 && keyColumns.size() == introspectedTable.getAllColumns().size()) {
			String domainObjectName = introspectedTable.getFullyQualifiedTable().getDomainObjectName();
			String primaryKeyType = topLevelClass.getType().getPackageName() +"."+ domainObjectName;
			updateFieldValue("baseShortName", domainObjectName, topLevelClass.getType());
			updateFieldValue("baseQualifiedName", primaryKeyType, topLevelClass.getType());
			introspectedTable.setPrimaryKeyType(primaryKeyType);
		}
        return true;
    }

    private void updateFieldValue(String fieldName, Object value, Object target){
    	try {
			java.lang.reflect.Field field = ReflectionUtils.getFieldByNameIncludingSuperclasses(fieldName, target.getClass());
			field.setAccessible(true);
			field.set(target, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
    }


	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		generateToString(introspectedTable, topLevelClass);
		return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
	}


	private void generateToString(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
		List<Field> fields = topLevelClass.getFields();
		Map<String, Field> map = new HashMap<String, Field>();
		for (Field field : fields) {
			map.put(field.getName(), field);
		}
		List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
		for (IntrospectedColumn column : columns) {
			Field f = map.get(column.getJavaProperty());
			if (f != null) {
				f.getJavaDocLines().clear();
				if (column.getRemarks() != null && column.getRemarks().trim().length() > 0) {
					f.addJavaDocLine("/** " + column.getRemarks() + " */");
				}
			}
		}
	}

}