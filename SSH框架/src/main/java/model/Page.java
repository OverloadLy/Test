package model;

public class Page {
	//��ҳ��,Ĭ������Ϊ1���������ó�������
	private int totalpage=1;
	//�ܼ�¼��
	private  int totalCount=0;
	//��ǰҳ��
	private int pageNo=1;
	//ҳ����ʾ������
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
			//������ҳ��
			this.setTotalpage();
		}
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		//�жϽ��յ�ҳ���Ƿ����0�����ڲ�set
		if(pageNo>0){
			this.pageNo = pageNo;
		}
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		//�ж���ʾ�������Ƿ����0�����ڲ�set
		if(pagesize>0){
			this.pagesize = pagesize;
		}
	}
		
	//��ȡ�ܵ��ж���ҳ
	public void setTotalpage(){
		if(this.totalCount%this.pagesize==0){
			//�жϣ�����¼��������ÿҳ��ʾ������������0ʱ����ҳ��Ϊ
			this.totalpage=this.totalCount/this.pagesize;
			//�жϣ�����¼��������ÿҳ��ʾ������������0ʱ����ҳ��Ϊ
		}else if(this.totalCount%this.pagesize>0){
			this.totalpage=this.totalCount/this.pagesize+1;
		}else{
			this.totalpage=0;
		}
	}
}
