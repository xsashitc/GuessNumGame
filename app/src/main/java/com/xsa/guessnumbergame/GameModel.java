package com.xsa.guessnumbergame;

/**
 * @author xsa
 * @package com.xsa.guessnumbergame
 * @fileName GameModel
 * @date on 2018/2/27 11:15
 */


public class GameModel {

    private int result = 0;

    public void add(int num){
        result += num;
    }

    public int getResult(){
        return result;
    }
}
