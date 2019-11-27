package demo;

public class number {

	public static void main(String[] args) {
		String inline = "999";
		int tram, chuc, donvi;
		int i = Integer.parseInt(inline);
		inline = "";
		tram = i/100;
        chuc = (i-(tram*100))/10;
        donvi = (i-((tram*100)+(chuc*10))); 
         switch(tram)
         {
             case 1:inline="Một trăm";break;
             case 2:inline="Hai trăm";break;
             case 3:inline="Ba trăm";break;
             case 4:inline="Bốn trăm";break;
             case 5:inline="Năm trăm";break;
             case 6:inline="Sáu trăm";break;
             case 7:inline="Bảy trăm";break;
             case 8:inline="Tám trăm";break;
             case 9:inline="Chín trăm";break;
         }
//         System.out.println(a);
         switch(chuc)
         {
             case 1:inline=inline+" Mười";break;
             case 2:inline=inline+" Hai mươi";break;
             case 3:inline=inline+" Ba mươi";break;
             case 4:inline=inline+" bốn mươi";break;
             case 5:inline=inline+" năm mươi";break;
             case 6:inline=inline+" sáu mươi";break;
             case 7:inline=inline+" bảy mươi";break;
             case 8:inline=inline+" tám mươi";break;
             case 9:inline=inline+" chín mươi";break;
         }
         switch(donvi)
         {
             case 1:inline=inline+" Mot";break;
             case 2:inline=inline+" Hai ";break;
             case 3:inline=inline+" Ba ";break;
             case 4:inline=inline+" Bon ";break;
             case 5:inline=inline+" Nam ";break;
             case 6:inline=inline+" Sau ";break;
             case 7:inline=inline+" bay ";break;
             case 8:inline=inline+" Tam ";break;
             case 9:inline=inline+" chin ";break;
         }
         System.out.println(inline);
	}

}
