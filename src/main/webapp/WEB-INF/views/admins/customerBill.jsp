<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Generating Bill</title>

<link href="http://fonts.googleapis.com/css?family=Didact+Gothic"
	rel="stylesheet" />

	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/menucss/offer.css"
	type="text/css" media="all" />
<style>
body{
	background-image: none;
}
table,th,td {
	border: 2px solid green;
	background-color: #eeffcc;
}
.button {
  font: bold 11px Arial;
  text-decoration: none;
  background-color: #EEEEEE;
  color: #333333;
  padding: 2px 6px 2px 6px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
}


</style>
</head>

<body bgcolor="#FFFFFF" text="#000000" link="#0000FF" vlink="#800080"
	alink="#FF0000">
	<center>
			<div style="width: 100%">
	<form action="customerBill" method="get">
		

				<center>
					<font size="5" color="blue"><b>${hotel_name}</b></font><br /> <br />
				</center>
				&nbsp;<br>
				<hr width="100%" size="1" />
				<br />

				<h2 align="center">
					Order<b> Invoice</b>
				</h2>

			<!-- 	Enter Table No :<input type="text" name="table_id" />  -->
				 TABLE ID :<select
				name="table_id">
				<c:forEach items="${listOfTableBook}" var="tableId">
					<option value="${tableId.getTable_id()}">TABLE NO
						${tableId.getTable_id()}</option>
				</c:forEach>
				</select>
				
				
				<input
					type="submit" name="action" value="GenerateBill"> <br>
				<br>
				<table border="1" cellpadding="5" cellspacing="0" width="600">

					<!-- HEADER -->
					<tbody>
						<tr>
							<th>Table_id</th>
							<th>FoodName</th>
							<th>Unit Price</th>
							<th>Quantity</th>
							<th>Amount</th>
						</tr>
					</tbody>

					<c:forEach items="${orderData}" var="data">
						<tr>
							<td width="100"><c:out value="${data.table_id}" /></td>
							<td width="100" align="CENTER"><c:out
									value="${data.food_name}" /></td>
							<td width="100" align="CENTER"><c:out value="${data.rate}" /></td>
							<td width="100" align="CENTER"><c:out
									value="${data.quantity}" /></td>
							<td width="100" align="CENTER"><c:out
									value="${data.sub_total}" /></td>
							<c:set var="total" value="${data.sub_total+total}" />
						</tr>
					</c:forEach>


					<tr>
						<td colspan="3">&nbsp;</td>
						<td style="border: solid 1px #000000;" align="Right">Total</td>
						<c:set var="totalDiscount" value="${totalDiscount}" />
						<td style="border: solid 1px #000000;" align="center"><c:out value="${total}" /></td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td style="border: solid 1px #000000;" align="Right">Total Discount</td>
						<c:set var="totalDiscount" value="${totalDiscount}" />
						<td style="border: solid 1px #000000;" align="center"><c:out value="${totalDiscount}" /></td>
					</tr>

					<tr>
						<td colspan="3">&nbsp;</td>
						<td style="border: solid 1px #000000;" align="Right"><b>Total Bill</b></td>
						<td style="border: solid 1px #000000;" align="center"><c:set var="TotalBill" value="${total-totalDiscount}"/><c:out value="${TotalBill}" /><b></b></td>
					</tr>
					
					<tr>
						<td colspan="3">&nbsp;</td>
						<td style="border: solid 1px #000000;" align="Right"><b>VAT(12%)</b></td>
						<td style="border: solid 1px #000000;" align="center">
						
						<c:set var="Vat" value="${TotalBill*(12/100)}"/>
					
						<c:out value="${Vat}" /><b></b></td>
					</tr>
					<tr>
						<td colspan="3">&nbsp;</td>
						<td style="border: solid 1px #000000;" align="Right"><b>Grand Total</b></td>
						<td style="border: solid 1px #000000;" align="center"><c:out value="${TotalBill+Vat}" /><b></b></td>
					</tr>
				</table>
			
				<br>
				</form>
				
				<c:forEach items="${orderData}" var="data">
				<c:set var="table_id" value="${data.table_id}" />
				</c:forEach>
				<form action="${pageContext.request.contextPath}/checkOut/${table_id}" method="get">
				
				 <input	type="submit" name="action" value="CheckOut" class="button"> <br>
				 </form>
				 	<br /> <br /> Payment Due upon reciept<br /> Thank you for your	Visit!
			</div>
		</center>
	
</body>

</html>