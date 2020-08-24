   $(document).ready(function(e){
		$("#userEmail").blur(function(event){
			$("#dupEmail").html("");
			var emailId = $("#userEmail").val();
			$.ajax({
				url : 'validateEmail?userEmail=' + emailId,
				success : function(abc){
					if(abc == 'Duplicate'){ 
					$("#dupEmail").html("Email already registered");
					$("#userEmail").focus();
				}
					}
				
			});
		});
	});
  
  $(document).ready(function(event) {
		$("#countryId").change(function() {
			
			$("#stateId").find('option').remove();
			$('<option>').val('').text('-Select-').appendTo("#stateId");
			
			$("#cityId").find('option').remove();
			$('<option>').val('').text('-Select-').appendTo("#cityId");
			
			var countryId = $("#countryId").val();
			$.ajax({
				type : "GET",
				url : "getStates?countryId=" + countryId,
				success : function(res) {
					$.each(res, function(stateId, stateName) {
						$('<option>').val(stateId).text(stateName).appendTo("#stateId");
					});
				}
			});
		});
  });
  
     
  $(document).ready(function(event){
	  $("#stateId").change(function(){
		  $("#cityId").find('option').remove();
			$('<option>').val('').text('-Select-').appendTo("#cityId");
			var stateId= $("#stateId").val();
			$.ajax({
				
				type : "GET",
				url : "getCitys?stateId=" + stateId,
				success : function(res){
					
					$.each(res,function(cityId, cityName){
						$('<option>').val(cityId).text(cityName).appendTo("#cityId")
					});
					
				}
			
				
			});
		  
	  });
  });
  
  
  $(document).ready(function(e){
		$("#tempPazzword").blur(function(event){
			$("#wrongpsw").html("");
			var emailId = $("#email").val();
			var psw =  $("#tempPazzword").val();
			
			$.ajax({
				url : 'validPazzword?userEmail='+emailId + '&userPazzword=' + psw,
				success : function(res){
					if(res == 'password is not there'){ 
					$("#wrongpsw").html("Yor Temprary Password is Worng PlseCheck once!");
					$("#tempPazzword").focus();
				}
					}
				
			});
		});
	});
  
  
  