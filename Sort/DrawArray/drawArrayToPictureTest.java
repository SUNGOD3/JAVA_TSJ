    import javax.swing.*; 
    import java.awt.*; 
    import java.awt.geom.*; 
    public class drawArrayToPictureTest {
         public static void main(String[] args) {
            int [] tmp = new int[5];
            for(int i=0;i<5;++i){
                tmp[i]=i;
            }
            JFrame application = new JFrame("A simple paint program");
            newArray tmp2 = new newArray(tmp, 0, 5);
            drawArrayToPicture test = new drawArrayToPicture(tmp2); 
            application.add(test); 
            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            application.setSize(1000, 600);
            application.setVisible(true); 
            
        }
    } 