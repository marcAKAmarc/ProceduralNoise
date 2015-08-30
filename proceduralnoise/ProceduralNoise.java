/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceduralnoise;
import java.nio.ByteBuffer;
import java.util.*;
/**
 *
 * @author luckynoface
 */
public class ProceduralNoise {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //debug 
        args = new String[3];
        args[0] = "10";
        args[1] = "D:/output.wav";
        args[2] = "0";
        //goal length (int), output path (string), function index
        int goalLength;
        String path;
        int functionIndex;
        goalLength = getGoalLength(args);
        path = getPath(args);
        functionIndex = getFunctionIndex(args);
        
        Wav wav = new Wav(path);
        ArrayList<Float> data = getData(functionIndex, goalLength);
        
        byte[] byteData = convertFloatArrayToByteArray(data);
        
        boolean success = wav.save();
        
        if(success)
            System.out.println("Wave file was totally successful and created at " + path);
        else
            System.out.println("Wav file creation failed!!!");
    }
    
    private static ArrayList<Float> getData(int functionIndex, int goalLength){
        switch(functionIndex){
           default: return  new ArrayList<Float>();
        }
    }
    
    private static int getGoalLength(String[] args){
       return Integer.parseInt(args[0]);
    }
    private static String getPath(String[] args){
        return args[1];
    }
    private static int getFunctionIndex(String[] args){
        return Integer.parseInt(args[2]);
    }
    
    private static byte[] convertFloatArrayToByteArray(ArrayList<Float> data){
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        for(int i = 0; i < data.size(); i++){
            long overallVal = (long)(data.get(i)*65535.0f);
            byte[] bytesArray = longToByteArray(overallVal);
            for(int b = 0; b< bytesArray.length; b++){
                bytes.add(bytesArray[b]);
            }
        }
        byte[] returnArr = toByteArray(bytes);
        return returnArr;
    
    }
    
    private static byte[] longToByteArray(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }
    public static byte[] toByteArray(List<Byte> in) {
        final int n = in.size();
        byte ret[] = new byte[n];
        for (int i = 0; i < n; i++) {
            ret[i] = in.get(i);
        }
        return ret;
    }
}
