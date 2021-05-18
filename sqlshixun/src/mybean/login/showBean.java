package mybean.login;

public class showBean {
String []columnName;        //存放列名
String [][]tableRecord =null;//存放查询到的记录
int pageSize = 5;//每页显示的记录数
int totalPages=1;  //分页后的总页数
int currentPage = 1;//当前显示页
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
