package Tasks;

public class Task_2 {
    public String[][] lyrics = {…};
    public static void main (String[] args){
        Task_2 test = new Task_2();
        test.OutPut(test.lyrics);
    }
  
    public void OutPut(String[][] a){
       for(int i=0; i<23; i++){
            for(int j=0; j<2; j++){
                if(a[i][j] == "Sonny, Cher"){
                    System.out.println("Sonny : " + a[i][1]);
                    System.out.println("Cher : " + a[i][1]);
                    break;
                }else if(a[i][j] == "Cher"){
                    System.out.print(a[i][j] + " : ");
                }else if(a[i][j] == "Sonny"){
                    System.out.print(a[i][j] + " : ");
                }else System.out.println(a[i][j]);
            }           
        }
    }
}
