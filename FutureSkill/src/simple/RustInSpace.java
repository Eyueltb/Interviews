package simple;


public class RustInSpace {
    private IRustInSpace api;
    public RustInSpace(IRustInSpace api) {

        // You can initiate and calculate things here
    }



    /**
     * To complete level two return "Hello World" here.
     */
    public String level2SayHello() {
        // Write your code here
        return "Hello World";
    }
    /**
     * To complete level three reverse the input value and return it
     */
    public String level3ProcessInput(String inputValue) {
        // Write your code here
        StringBuilder builder = new StringBuilder(inputValue);
        builder.reverse();
        return builder.toString();
    }

    /**
     * To complete level four take the x and y values and use them to set the
     * destination using the api
     */
    public void level4UseTheApi(int x, int y) {
        // Write your code here
        api.setDestination(x, y);
    }



}
interface IRustInSpace{
   void setDestination(int x, int y);
}