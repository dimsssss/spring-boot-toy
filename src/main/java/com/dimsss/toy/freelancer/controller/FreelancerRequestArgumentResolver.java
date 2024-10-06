package com.dimsss.toy.freelancer.controller;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

@Component
public class FreelancerRequestArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(FreelancerDto.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws IllegalArgumentException {

        String sort = Optional.ofNullable(webRequest.getParameter("sort")).orElse("");
        int page = Integer.parseInt(Optional.ofNullable(webRequest.getParameter("lastId")).orElse("1"));
        int limit = Integer.parseInt(Optional.ofNullable(webRequest.getParameter("limit")).orElse("30"));

        return new FreelancerDto(SortType.fromField(sort), page, limit);
    }
}
