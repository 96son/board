

let dtBoardList;
function initializeDataTable() {
	
    dtBoardList = $("#dataTable").DataTable({
        lengthChange: false,
        searching: false,
        info: false,
        paging: false,
        select: false,
        searching:false,
        ordering: false, // 정렬기능 on off 여부
        columnDefs:[
			{visible : true, targets:[0]}
		]
        
			        
    });
}

//createRow 원본
//function createRow(filename, filesize)
//{
 //   dtBoardList.row.add([ filename, filesize ]).draw();
//}

//가변변수 용도
function createRow(...params) {
	dtBoardList.row.add(params).draw();
}


//데이터테이블 로우 이벤트
$("#dataTable").on("click", "tbody tr", function() {
	
	//로우 값 
	var temp = $("#dataTable").DataTable().row($(this)).data();
	var boardSeq = temp[0];
	alert(temp);
	
	location.href = "/board/viewBoardDtlPage?boardSeq="+boardSeq;	
});
