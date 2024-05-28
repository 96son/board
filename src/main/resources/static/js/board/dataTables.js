

let dtBoardList;
function initializeDataTable()
{
    dtBoardList = $("#tbBoardList").DataTable(
    {
        lengthChange: false,
        searching: false,
        info: false,
        paging: false,
        select: false,
        ordering: false // 정렬기능 on off 여부
        
    });
}

//createRow 원본
//function createRow(filename, filesize)
//{
 //   dtBoardList.row.add([ filename, filesize ]).draw();
//}

//가변변수 용도
function createRow(...params)
{
	dtBoardList.row.add(params).draw();
}

