<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Вики-чат</title>
		<script language="javascript" type="text/javascript">
	        var xmlHttp=false;
	        try{
	                xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	        }catch(e){
	                try{
	                        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	                }catch(e2){
	                        xmlHtpp=false;
	                }
	        }
	
	        if(!xmlHttp && typeof XMLHttpRequest!='undefined'){
	                xmlHttp=new XMLHttpRequest();
	        }
	        
	        window.onload=function(){
	            updateChat();
	            setInterval(updateChat, 5000);
	        }
	        
            function updateChat(){
                var query='ChatServlet?command=getChat';

                xmlHttp.open("POST",query,true);
                xmlHttp.onreadystatechange=function(){
                	if(xmlHttp.readyState==4&&xmlHttp.status==200){
                		var response=xmlHttp.responseText;
                		document.getElementById("chatboxId").innerHTML = response;
                		document.getElementById("chatboxId").scrollTop = 9999
                    }
                };
                xmlHttp.send(null);
            };
            
			function sendMessage(){
				var mesg = document.getElementById('messageId').value;
				if(mesg.length>0){
	                var query='ChatServlet?command=add';
	                query+='&message='+mesg;
	
	                xmlHttp.open("POST",query,true);
	                xmlHttp.onreadystatechange=function(){
	                    if(xmlHttp.readyState==4&&xmlHttp.status==200)
	                        updateChat();
	                };
	                xmlHttp.send(null);
	                document.getElementById('messageId').value='';
                }		
			};

		</script>
	</head>
<body>
	<h1>Добро пожаловать в Вики-чат</h1>
	
	<div id="chatboxId" style="width: 400px;
					  		 height: 200px;
					  		 border-width: 1px;
					  		 border-color: black;
					  		 border-style: solid;
					  		 overflow-y: scroll;">
			
	</div>
	
	<br>
		
		Text: <input type="text" name="message" id="messageId" style="width: 250px">
		<input type="button" value="Отправить" onclick="sendMessage();" />
	
</body>
</html>