package mybean.login;

public class showBean {
String []columnName;        //�������
String [][]tableRecord =null;//��Ų�ѯ���ļ�¼
int pageSize = 5;//ÿҳ��ʾ�ļ�¼��
int totalPages=1;  //��ҳ�����ҳ��
int currentPage = 1;//��ǰ��ʾҳ
public String[] getColumnName() {
	return columnName;
}
public void setColumnName(String[] columnName) {
	this.columnName = columnName;
}
public String[][] getTableRecord() {
	return tableRecord;
}
public void setTableRecord(String[][] tableRecord) {
	this.tableRecord = tableRecord;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getTotalPages() {
	return totalPages;
}
public void setTotalPages(int totalPages) {
	this.totalPages = totalPages;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}


}
