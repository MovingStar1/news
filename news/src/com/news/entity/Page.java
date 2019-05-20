package com.news.entity;

import java.util.List;

public class Page {
     private int currentPage;//��ǰҳ
     private int totalPage;//��ҳ��
     private int PageSize;//ÿҳ��ʾ������
     private int totalCount;//������
 	 private List<News> list;//��ǰҳ�����ݼ���
     public Page() {
		// TODO Auto-generated constructor stub
	}
     public Page(int currentPage, int totalPage, int pageSize,
    		 int totalCount, List<News> list) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.PageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", totalPage=" + totalPage
				+ ", PageSize=" + PageSize + ", totalCount=" + totalCount
				+ ", list=" + list + "]";
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage){
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return PageSize;
	}
	/*
	 * ��ҳ��=��������*ҳ���С==0?��������/ҳ���С����������/ҳ���С+1;
	 * �����ǵ���������������set������get�����Ժ��Զ������ҳ��
	 */
	public void setPageSize(int pageSize) {
		this.PageSize = pageSize;
		//�Զ�������ҳ��
		// ��ҳ��=��������%ҳ���С==0?��������/ҳ���С����������/ҳ���С+1;
		this.totalPage=this.totalCount%this.PageSize==0?this.totalCount/this.PageSize:this.totalCount/this.PageSize+1;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<News> getList() {
		return list;
	}
	public void setList(List<News> list) {
		this.list = list;
	}

}
