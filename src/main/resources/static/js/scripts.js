$(document).ready(function(){
	
	 $('.delete-book').click(function(){
		 
		 /*<![CDATA[*/
		    var path = /*[ [@{/}] ]*/'remove';
			/*]]>*/
			
			
			var id = $(this).attr('id');
			
			 bootbox.confirm({
				    message:  "Are you sure to remove this book? It can't be undone.",
				    buttons: {
				        confirm: {
				            label: '<i class="fa fa-check"></i> Confirm',
				            className: 'btn-success'
				        },
				        cancel: {
				            label: '<i class="fa fa-times"></i> Cancel',
				            className: 'btn-danger'
				        }
				    },
				    callback: function (confirmed) {
				        if(confirmed){
				        	$.post(path,{'id': id}, function(result){
				        		location.reload();
				        	});
				        }
				    }
				});
		 
	 });
	
	 
	/* var bookIdList=[];
	 $('.checkboxBook').click(function(){
		 	var id = $(this).attr('id');
		
			if(this.checked){
				bookIdList.push(id);
			}else{
				bookIdList.splice(bookIdList.indexOf(id),1);
			}
	 });*/
	 
	 $('#deleteSelected').click(function(){
		 var idList = $('.checkboxBook');
		 
		 var bookIdList=[];
		 
		 for(var i =0; i< idList.length; i++){
			 
			 if(idList[i].checked==true){
				 bookIdList.push(idList[i]['id']);
			 }
		 }
		 
		 /*<![CDATA[*/
		    var path = /*[ [@{/}] ]*/'removeList';
			/*]]>*/
		    
		    var id = $(this).attr('id');
		    
		    bootbox.confirm({
			    message:  "Are you sure to remove all selected books? It can't be undone.",
			    buttons: {
			        confirm: {
			            label: '<i class="fa fa-check"></i> Confirm',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: '<i class="fa fa-times"></i> Cancel',
			            className: 'btn-danger'
			        }
			    },
			    callback: function (result) {
			        if(result){
			        	$.ajax({
			        		type: 'POST',
			        		url : path,
			        		data : JSON.stringify(bookIdList),
			        		contentType : 'application/json',
			        		success : function (result){
			        			console.log(res);
			        			location.reload();
			        		},
			        		error : function (result){
			        			console.log(res);
			        			location.reload();
			        		}
			        			
			        	});
			        }
			    }
			});
	 });
	 
	 $('#selectAllBooks').click(function(){
		 
		 if($(this).prop('checked') == true){
			 
			 $('.checkboxBook').prop('checked',true);
			 
		 }else if($(this).prop('checked') == false){
		
			 $('.checkboxBook').prop('checked',false);
		 
		 }
		 
	 });
});