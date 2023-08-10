module test {
	exports com.kh.test.model.service;
	exports com.kh.test.model.dao;
	exports com.kh.test.model.vo;
	exports com.kh.test.controller;

	requires java.servlet;
	requires java.sql;
}