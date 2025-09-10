package com.stackroute.javabased;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanMonitor implements BeanPostProcessor{
	// simply return the instantiated bean as-is
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		
		System.out.println("Bean is getting initialized " + beanName);
		return bean; // we could potentially return any object reference here...
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) {
		
		System.out.println("Bean '" + beanName + "' created : " + bean.toString());
		
		if(bean instanceof Bill)
		{
			Bill billobj=(Bill)bean;
			billobj.setCustomername("Jhony");
			return billobj;
		}
		return bean;
	}
}
