//Author: Alexis Navarro
//Lab 4
//Last modification: 10/11/18
class Box{
    Box next;
    private double height;
    private double length;
    private double width;
    private double Volume;
    private boolean Cubic;
    
//Constructors
    Box(){}
    
    //Box method that works to store the dimensions of the package that comes from the text file
    Box(double height, double length, double width){
        this.height = height;
        this.length = length;
        this.width = width;
    }
 
    
//getters
    public double getWidth(){
        return width;
    } 
    public double getLength(){
        return length;
    }
    public double getHeight(){
        return height;
    }
	public double getVolume(){
		return width*height*length;
    }//end getVolume

    public boolean getCubic(){
        if(width==height && width == length){
            return true;
        }else{
            return false;
        }
    }//end getCubic 
}//end Box