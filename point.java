package jing.able;

/**
 * @author: panjing
 * @describe:     马的遍历
 * @date: 2019/4/27
 * @time: 22:52
 */

/**
 * 问题描述：在8x8的方格棋盘上，从任意指定的方格出发，为马寻找一条走遍棋盘每一格
 * 并且只经过一次的一条路径。
 *
 *
 * 问题分析：马在某个方格，可以在一步内到达的不同位置最多有8个，
 * 如果用矩阵M表示棋盘，其元素记录马经过该位置时的步骤号，另对马的8种可能走法，
 * 设定一个顺序，如果当前位置在棋盘的M（i,j），下一个可能的位置以次为：
 * (M(i+2, j+1))
 * (M(i+1, j+2))
 * (M(i-1, j+2))
 * (M(i-2, j+1))
 * (M(i-2, j-1)) 
 * (M(i-1, j-2))
 * (M(i+1, j-2))
 *(M(i+2, j-1)) 
 */
public class point{
        private int x;
        private int y;
        public point(int x,int y){
            this.x=x;
            this.y=y;
        }
        public int  getX(){
            return x;
        }
        public int getY() {
            return y;
        }
        public void setX(int x){
            this.x=x;
        }
        public void setY(int y) {
            this.y=y;
        }
    }
    class TracePoint
    {
        point thePoint;
        int direction;
        public TracePoint()
        {
            thePoint=new point(-1,-1);
            this.direction=0;
        }
        public TracePoint(int x,int y)
        {
            thePoint=new point(x,y);
            this.direction=0;
        }

        public point getPoint() {
            return thePoint;
        }
        public void setPoint(point t){
            thePoint.setX(t.getX());
            thePoint.setY(t.getY());
        }
        public int getDirection(){
            return direction;
        }
        public void setDirection(int t){
            this.direction=t;
        }
        public void reset(){
            thePoint.setX(-1);
            thePoint.setY(-1);
            direction=0;
        }
        public void setX(int x){
            thePoint.setX(x);
        }
        public void setY(int y){
            thePoint.setY(y);
        }
        public int getX(){
            return thePoint.getX();
        }
        public int getY(){
            return thePoint.getY();
        }
    }
    class Trace {
        private int total;
        private TracePoint[] grid;
        private boolean[][] field;
        public Trace(){
            grid=new TracePoint[64];
            field=new boolean[8][8];
            for(int i=0;i<64;i++) {
                grid[i]=new TracePoint();
            }
            for(int i=0;i<8;i++){
                for (int j=0;j<8 ; j++){
                    field[i][j]=false;
                }
            }
            total=0;
        }
        public int getTotal(){
            return total;
        }
        public void setTotal(int t){
            this.total=t;
        }
        public TracePoint[] getGrid(){
            return this.grid;
        }
        public TracePoint getElement(int i){
            return grid[i];
        }
        public TracePoint getLastElement(){
            return grid[total-1];
        }
        public boolean isSelected(int x,int y){
            return this.field[x][y];
        }
        public void setSelected(int x,int y,boolean b){
            field[x][y]=b;
        }
        public void reset(int i){
            field[grid[i].getX()][grid[i].getY()]=false;
            grid[i].reset();
        }
        public void backOneStep(){
            reset(total-1);
            total--;
        }
        public void output(){
            for(int i=0;i<64;i++){
                System.out.println("("+grid[i].getX()+","+grid[i].getY()+")");
            }
        }
    }
    class BianLi{
        private point[] direction;//方向。
        private Trace trace;//记录已经走过的路经
        public BianLi(){
            direction =new point[8];
            direction[0]=new point(-2,-1);
            direction[1]=new point(-1,-2);
            direction[2]=new point(1,-2);
            direction[3]=new point(2,-1);
            direction[4]=new point(2,1);
            direction[5]=new point(1,2);
            direction[6]=new point(-1,2);
            direction[7]=new point(-2,1);
            trace=new Trace();
        }
        public void starPlay(int x,int y){       //从点（x,y）开始
            trace.setTotal(1);
            trace.getLastElement().setX(x);
            trace.getLastElement().setY(y);
            trace.setSelected(x,y,true);
            while(trace.getTotal()<64){
                TracePoint nextPoint=choose();
                if(nextPoint==null) {
                    if(!back()){
                        break;
                    }
                }
                else{
                    if(!forward(nextPoint)){
                        break;
                    }
                }
            }
            if(trace.getTotal()==64){
                trace.output();
            }else{
                System.out.println("搜索失败！！！！");
            }
        }
        public TracePoint choose(){         //选择下一个点
            int x;
            int y;
            for(int i=trace.getLastElement().getDirection();i<8;i++){
                x=trace.getLastElement().getX()+direction[i].getX();
                y=trace.getLastElement().getY()+direction[i].getY();
                if(x>=0&&x<8&&y>=0&&y<8&&!trace.isSelected(x,y)){
                    trace.getLastElement().setDirection(i);
                    return new TracePoint(x,y);
                }
            }
            return null;
        }
        public boolean forward(TracePoint t){       //前进
            if(trace.getTotal()==64){
                return false;
            }
            trace.setTotal(trace.getTotal()+1);
            trace.getElement(trace.getTotal()-1).setDirection(t.getDirection());
            trace.getElement(trace.getTotal()-1).setX(t.getX());
            trace.getElement(trace.getTotal()-1).setY(t.getY());
            trace.setSelected(t.getX(),t.getY(),true);
            return true;
        }
        public boolean back(){          //回退
            while(trace.getTotal()>=0){
                if(trace.getLastElement().getDirection()==8){
                    trace.backOneStep();
                }else{
                    break;
                }
            }
            if(trace.getTotal()>=0){
                trace.getLastElement().setDirection(trace.getLastElement().getDirection()+1);//下一个方向
                return true;
            }
            return false;
        }

        public static void main(String[] args){
            BianLi horse=new BianLi();
            horse.starPlay(0,0);
        }

}
