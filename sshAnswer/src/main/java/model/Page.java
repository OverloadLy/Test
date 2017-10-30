package model;

public class Page {
	//总页数,默认设置为1，可以设置成其他的
	private int totalpage=1;
	//总记录数
	private  int totalCount=0;
	//当前页码
	private int pageNo=1;
	//页面显示多少条
	private int pagesize=5;
		
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
			this.totalCount = totalCount;
			//设置总页数
			this.setTotalpage();
		}
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		//判断接收的页码是否大于0，大于才set
		if(pageNo>0){
			this.pageNo = pageNo;
		}
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		//判断显示的行数是否大于0，大于才set
		if(pagesize>0){
			this.pagesize = pagesize;
		}
	}
		
	//获取总的有多少页
	public void setTotalpage(){
		if(this.totalCount%this.pagesize==0){
			//判断，当记录总数除以每页显示数量的余额等于0时，总页数为
			this.totalpage=this.totalCount/this.pagesize;
			//判断，当记录总数除以每页显示数量的余额大于0时，总页数为
		}else if(this.totalCount%this.pagesize>0){
			this.totalpage=this.totalCount/this.pagesize+1;
		}else{
			this.totalpage=0;
		}
	}
}
