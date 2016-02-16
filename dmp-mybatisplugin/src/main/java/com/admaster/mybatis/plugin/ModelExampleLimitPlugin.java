package com.admaster.mybatis.plugin;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class ModelExampleLimitPlugin extends PluginAdapter {

	private String limitTypeString = "com.hunteron.common.mybatis.plugin.Limit";

	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		FullyQualifiedJavaType limitType = new FullyQualifiedJavaType(limitTypeString);
		topLevelClass.addImportedType(limitType);

		Field field = new Field();
		field.setName("limit");
		field.setType(limitType);
		field.setVisibility(JavaVisibility.PRIVATE);
		topLevelClass.addField(field);

		Method setMethod = new Method();
		setMethod.setName("setLimit");
		setMethod.setVisibility(JavaVisibility.PUBLIC);
		setMethod.addParameter(new Parameter(limitType, "limit"));
		setMethod.addBodyLine("this.limit = limit;");
		topLevelClass.addMethod(setMethod);

		Method getMethod = new Method();
		getMethod.setName("getLimit");
		getMethod.setVisibility(JavaVisibility.PUBLIC);
		getMethod.setReturnType(limitType);
		getMethod.addBodyLine("return this.limit;");
		topLevelClass.addMethod(getMethod);

		
		FullyQualifiedJavaType cr = new FullyQualifiedJavaType("Criterion");
		
		
		List<InnerClass> innerClasses = topLevelClass.getInnerClasses();
		for (InnerClass innerClass : innerClasses) {
			if (innerClass.isStatic() && innerClass.isAbstract()){
				List<Method> methods = innerClass.getMethods();
				for (Method method : methods) {
					if (method.getName().equalsIgnoreCase("addCriterion")) {
						method.setVisibility(JavaVisibility.PUBLIC);
					}
				}
				
				Method innerMethod = new Method();
				innerMethod.setName("addCriterion");
				innerMethod.addParameter(new Parameter(cr, "criterion"));
				innerMethod.setVisibility(JavaVisibility.PUBLIC);
				innerMethod.addBodyLine("if (criterion == null) {");
				innerMethod.addBodyLine("throw new RuntimeException(\"Value for criterion cannot be null\");");
				innerMethod.addBodyLine("}");
				innerMethod.addBodyLine("criteria.add(criterion);");
				methods.add(3, innerMethod);
			}
			if (innerClass.getType().getShortName().equalsIgnoreCase("Criterion")) {
				
				for (Method method : innerClass.getMethods()) {
					method.setVisibility(JavaVisibility.PUBLIC);
				}
				
				field = new Field();
				field.setName("orListValue");
				field.setType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
				field.setVisibility(JavaVisibility.PRIVATE);
				innerClass.addField(field);
				
				Method innerMethod = new Method();
				innerMethod.setConstructor(true);
				
				FullyQualifiedJavaType listtype = new FullyQualifiedJavaType("java.util.List<Criterion>");
				
				innerMethod.setName("Criterion");
				innerMethod.setVisibility(JavaVisibility.PUBLIC);
				innerMethod.addParameter(new Parameter(listtype, "listCriterion"));
				innerMethod.addBodyLine("super();");
				innerMethod.addBodyLine("this.value = listCriterion;");
				innerMethod.addBodyLine("this.orListValue = true;");
				innerClass.addMethod(innerMethod);
				
				innerMethod = new Method();
				innerMethod.setName("isOrListValue");
				innerMethod.setVisibility(JavaVisibility.PUBLIC);
				innerMethod.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
				innerMethod.addBodyLine("return orListValue;");
				innerClass.addMethod(innerMethod);
			}
			
		}
		return true;
	}


	@Override
	public boolean sqlMapExampleWhereClauseElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		List<Element> elementList = element.getElements();
		XmlElement endElement = (XmlElement) elementList.get(elementList.size() - 1);
		XmlElement elementByName = getElementByName(endElement, "choose");
		
		XmlElement when = new XmlElement("when");
		elementByName.addElement(when);
		
		when.addAttribute(new Attribute("test", "criterion.orListValue"));
		when.addElement(new TextElement("and"));
		
		XmlElement foreachEle = new XmlElement("foreach");
		foreachEle.addAttribute(new Attribute("collection", "criterion.value"));
		foreachEle.addAttribute(new Attribute("item", "listItem"));
		foreachEle.addAttribute(new Attribute("open", "("));
		foreachEle.addAttribute(new Attribute("close", ")"));
		foreachEle.addAttribute(new Attribute("separator", "or"));
		
		when.addElement(foreachEle);
		
		
		
		XmlElement chooseElement = new XmlElement("choose"); //$NON-NLS-1$
		foreachEle.addElement(chooseElement);

        when = new XmlElement("when"); //$NON-NLS-1$
        when.addAttribute(new Attribute("test", "listItem.noValue")); //$NON-NLS-1$ //$NON-NLS-2$
        when.addElement(new TextElement("${listItem.condition}")); //$NON-NLS-1$
        chooseElement.addElement(when);

        when = new XmlElement("when"); //$NON-NLS-1$
        when.addAttribute(new Attribute("test", "listItem.singleValue")); //$NON-NLS-1$ //$NON-NLS-2$
        when.addElement(new TextElement("${listItem.condition} #{listItem.value}"));
        chooseElement.addElement(when);

        when = new XmlElement("when"); //$NON-NLS-1$
        when.addAttribute(new Attribute("test", "listItem.betweenValue")); //$NON-NLS-1$ //$NON-NLS-2$
        when.addElement(new TextElement("${listItem.condition} #{listItem.value} and #{listItem.secondValue}"));
        chooseElement.addElement(when);

        when = new XmlElement("when"); //$NON-NLS-1$
        when.addAttribute(new Attribute("test", "listItem.listValue")); //$NON-NLS-1$ //$NON-NLS-2$
        when.addElement(new TextElement("${listItem.condition}")); //$NON-NLS-1$
        XmlElement innerForEach = new XmlElement("foreach"); //$NON-NLS-1$
        innerForEach.addAttribute(new Attribute("collection", "listItem.value")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addAttribute(new Attribute("item", "item")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addAttribute(new Attribute("open", "(")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addAttribute(new Attribute("close", ")")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addAttribute(new Attribute("separator", ",")); //$NON-NLS-1$ //$NON-NLS-2$
        innerForEach.addElement(new TextElement("#{item}"));
        when.addElement(innerForEach);
        chooseElement.addElement(when);
		
		return true;
	}
	
	private XmlElement getElementByName(XmlElement element, String tagName) {
		for (Element elements : element.getElements()) {
			if (elements instanceof XmlElement){
				XmlElement ele = (XmlElement)elements;
				if (ele.getName().equalsIgnoreCase(tagName)){
					return ele;
				} else if (ele.getElements().size() > 0){
					return getElementByName((XmlElement)elements, tagName);
				}
			}
		}
		return null;
	}
	
	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		addLimitSqlMapCode(element);
		return true;
	}

	@Override
	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		List<Element> elementList = element.getElements();
		XmlElement orderByElement = (XmlElement) elementList.get(elementList.size() - 1);
		orderByElement.getElements().set(0, new TextElement("order by ${orderByClause}"));
		addLimitSqlMapCode(element);
		return true;
	}

	private void addLimitSqlMapCode(XmlElement element) {
		XmlElement limit = new XmlElement("if");
		limit.addAttribute(new Attribute("test", "limit != null"));
		limit.addElement(new TextElement("limit #{limit.start},#{limit.size}"));
		element.addElement(limit);
	}
}
