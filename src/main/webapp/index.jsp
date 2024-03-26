<html>
<style>
body{
	height:100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}
img{
	height: 30vw;
	width: 40vw;
}
 h1{
 			margin-bottom:15vw;
 			margin-right:5vw;
 			
    
            background: linear-gradient(75deg,pink,purple,blue,skyblue,purple,pink);
            color: transparent;
            animation:effect 1s infinite;
            -webkit-background-clip: text;
            font-style: italic;
            font-family:Arial, Helvetica, sans-serif;
        }
        @keyframes effect{
            from{
                background-size: 1500px;
                background-position: 1500px;
            }
            to{
                background-position: 0px;
            }
        }
       input{
       height: 4vw;
       width: 10vw;
       font-family:Arial, Helvetica, sans-serif;
       color:purple;
       font-size: 1vw;
       font-weight:bold;
       border-radius: 5%;
       margin-left: 10vw;
       }
       input:hover{
       color:white;
       background-color: purple;
       }
</style>
<body>


	<img src="image1.gif">
	<div>
		<h1>Welcome To Employee Management System Project</h1>
		<form action="allEmployeeDetailes">
			<input type="submit" value="press to continue">
		</form>
	</div>
</body>



</html>
