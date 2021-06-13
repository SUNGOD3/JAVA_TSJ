import javax.swing.*;
import javax.swing.plaf.PanelUI;

import java.awt.*; 
    import java.awt.geom.*; 
    public class drawArrayToPicture extends JPanel{
        private int[] Array,drawColor[];
        private int arraySize,lowerBound,upperBound,dif;
        

        public drawArrayToPicture (int[] Array,int arraySize,int lowerBound,int upperBound){
            this.Array=Array;
            this.arraySize=arraySize;
            this.lowerBound=lowerBound;
            this.upperBound=upperBound;
            dif = upperBound-lowerBound;    
        }

        public drawArrayToPicture (newArray Arr){
            Array = Arr.getArray();
            arraySize = Arr.getArraySize();
            lowerBound = Arr.getLowerRange();
            upperBound = Arr.getUpperRange();
            dif = upperBound-lowerBound; 
        }

        public void paintComponent(Graphics g) { 
            super.paintComponent(g); 
            Graphics2D g2 = (Graphics2D)g; 
            Line2D [] lines = new Line2D[arraySize];
            g2.setColor(Color.blue); 
            g2.setStroke(new BasicStroke(10)); 
            for(int i=0;i<arraySize;++i){
                lines[i] = new Line2D.Double(i*10,500,i*10,(upperBound-Array[i])*dif*20);
                g2.draw(lines[i]);
            }
        } 

        public void setArray(int[] Array){
            arraySize = Array.length;
            int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE;
            for(int i=0;i<arraySize;++i){
                mi = Math.min(mi,Array[i]);
                ma = Math.max(ma,Array[i]);
            } 
            this.Array = Array;
            lowerBound = mi;
            upperBound = ma;    
        }
        

    } 