package cn.smbms.tools;

public class PageSupport {
	//当前页码-来自于用户输入
	private int currentPageNo = 1;
	
	//总数量（表）
	private int totalCount = 0;
	
	//页面容量
	private int pageSize = 0;
	
	//总页数-totalCount/pageSize（+1）
	private int totalPageCount = 1;

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	//设置当前页码
	public void setCurrentPageNo(int currentPageNo) {
		if(currentPageNo > 0){
			this.currentPageNo = currentPageNo;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	//总记录数
	public void setTotalCount(int totalCount) {
		if(totalCount > 0){
			this.totalCount = totalCount;
			//设置总页数
			this.setTotalPageCountByRs();
		}
	}
	public int getPageSize() {
		return pageSize;
	}

	//设置页容量
	public void setPageSize(int pageSize) {
		if(pageSize > 0){
			this.pageSize = pageSize;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	/*public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}*/

	//计算总页数
	public void setTotalPageCountByRs(){
		if(this.totalCount % this.pageSize == 0){
			this.totalPageCount = this.totalCount / this.pageSize;
		}else if(this.totalCount % this.pageSize > 0){
			this.totalPageCount = this.totalCount / this.pageSize + 1;
		}else{
			this.totalPageCount = 0;
		}
	}
	
}