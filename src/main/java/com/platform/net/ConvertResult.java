package com.platform.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.platform.util.ByteUtil;


public class ConvertResult {
	/**
	 * struct1{ char a 1/2/3/4, char[1000] b} model1 and model2 ,return num is 3   sizeof 1001
	 * struct2{char a 4,float[20] b,float[20] c ,float[20] d,float e ,float f, char g ,char h} model 3-model 6 sizeof256
	 * struct3{char ,float,float, int ,char[50],char[1000]} model7  sizeof1068
	 * struct4{char 标示,char 文件名长度,char[50] 文件名,char 文件名长度，char[50] 文件名,char[1000]数值} model8 sizeof1103
	 */
	
	
	/**
	 * 将返回结果转换为js可解析格式
	 * @param s
	 * @return
	 */
	//如果char是unsigned char（0-255的数字）
	//先末位加3个0变成byte数组 再ByteUtil.getInt
	public static String convertStruct1(byte[] recv){
		StringBuilder result = new StringBuilder();
		result.append(recv[0]+",");
		//高位
		byte[] temp = new byte[4];
		temp[1] = 0;
		temp[2] = 0;
		temp[3] = 0;
		
		for(int i = 1;i < 1001 ; i++){
			temp[0] = recv[i];
			
			//System.out.println(recv[i]+"");
			
			result.append(ByteUtil.getInt(temp));
			if(i!=1000)
				result.append("_");
		}
		
		return result.toString();
	}
	
	public static String convertStruct2(byte[] recv){
		StringBuilder result = new StringBuilder();
		
		result.append((int)recv[0]+",");
		
		for(int i = 4; i<252 ; i += 4){
			byte[] temp = new byte[4];
			temp[0] = recv[i];
			temp[1] = recv[i+1];
			temp[2] = recv[i+2];
			temp[3] = recv[i+3];
			result.append(ByteUtil.getFloat(temp));
			result.append("_");
		}
		
		result.append((int)recv[252]);
		result.append("_");
		result.append((int)recv[253]);
		
		return result.toString();
	}
	
	public static String convertStruct3(byte[] recv){
		StringBuilder result = new StringBuilder();
		result.append(""+(int)recv[0]+",");
		for(int i = 4; i<12 ; i += 4){
			byte[] temp = new byte[4];
			temp[0] = recv[i];
			temp[1] = recv[i+1];
			temp[2] = recv[i+2];
			temp[3] = recv[i+3];
			result.append(ByteUtil.getFloat(temp));
			result.append("_");
		}
		
		byte[] temp = new byte[4];
		temp[0] = recv[12];
		temp[1] = recv[13];
		temp[2] = recv[14];
		temp[3] = recv[15];
		result.append(ByteUtil.getInt(temp));
		result.append("_");
		
		byte[] temp2 = new byte[2];
		temp2[1] = 0;
		
		for(int i = 16;i<66;i++){
			temp2[0] = recv[i];
			result.append(ByteUtil.getChar(temp2));
			if(i!=65)
				result.append("_");
			else
				result.append("|");
		}
		
		for(int i=68;i<1068;i++){
			temp[0] = recv[i];
			System.out.println("recv"+i+"="+recv[i]);
			result.append(ByteUtil.getInt(temp));
			if(i!=1067)
				result.append("_");
		}
		
		return result.toString();
	}
	
	public static String convertStruct4(byte[] recv){
		StringBuilder result = new StringBuilder();
		result.append(""+(int)recv[0]+",");
		//高位
		byte[] temp = new byte[4];
		temp[1] = 0;
		temp[2] = 0;
		temp[3] = 0;
		
		byte[] temp2 = new byte[2];
		temp2[1] = 0;
		
		//文件名长度
		temp[0] = recv[1];
		result.append(ByteUtil.getInt(temp)+"_");
		//文件名
		for(int i = 2;i < 52;i++){
			temp2[0] = recv[i];
			result.append(ByteUtil.getChar(temp2)+"_");
		}
		
		//文件名长度
		temp[0] = recv[52];
		result.append(ByteUtil.getInt(temp)+"_");
		//文件名
		for(int i = 53;i < 103;i++){
			temp2[0] = recv[i];
			result.append(ByteUtil.getChar(temp2));
			if(i != 102)
				result.append("_");
			else
				result.append("|");
		}
		
		for(int i = 103;i < 1103;i++){
			temp[0] = recv[i];
			result.append(ByteUtil.getInt(temp));
			if(i!=1102)
				result.append("_");
		}
		return result.toString();
		//Result is =============3,9,t,e,s,t,.,s,h,d, , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , ,0,0, , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , ,150_180_190_218_198_191_190_191_197_212_208_197_194_195_198_209_218_202_197_197_199_207_240_206_200_198_200_206_226_211_203_200_201_205_218_218_205_201_201_204_213_228_208_203_202_204_211_245_212_205_203_204_209_226_217_207_204_204_208_219_223_209_205_204_207_215_237_212_206_205_206_212_238_216_208_205_206_211_225_221_210_206_206_209_219_228_212_207_206_209_216_248_215_208_207_208_214_234_219_210_207_208_212_224_224_212_208_208_211_220_234_214_209_208_210_216_251_217_210_208_209_214_231_222_212_209_209_213_224_228_214_209_209_211_220_241_216_210_209_211_217_242_220_212_209_210_215_229_224_213_210_210_213_223_232_216_211_210_212_219_251_218_212_210_211_217_237_222_213_210_211_215_228_227_215_211_211_214_223_237_217_212_211_213_219_255_220_213_211_212_217_234_224_215_211_212_215_227_230_216_212_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128_128
	}
	
	
	/**
	 * 解析模型类型
	 */
	public static String convertMt(byte[] recv){
		String jsonResult = new String();
		List<String> result = new ArrayList<String>();
		ModelType mt = new ModelType();
		for(int i=0 ; i<recv.length;i=i+28){
			
			
			byte[] temp = Arrays.copyOfRange(recv, i,i+28);
//			for (int j = 0; j < temp.length; j++) {
//				System.out.print(temp[j]+",");
//			}
//			System.out.println("");
			byte[] ip = {temp[0],temp[1],temp[2],temp[3],0,0,0,0};
			mt.ip = ByteUtil.getString(ip);
			
			
			byte[] type = {temp[4],0,0,0};
			mt.type = ByteUtil.getInt(type);
			
			char[] name = new char[16];
			for(int j = 8;j <=23;j++ ){
				byte[] temp2 = {temp[j],0,0,0};
				
				name[j-8]=ByteUtil.getChar(temp2);
				
			}
			mt.name = new String(name);
			
			byte[] index = {temp[24],0,0,0};
			mt.index = ByteUtil.getInt(index);
			//加入type不为0，即有效的元素
			if(mt.type != 0){
				System.out.println("type is "+mt.type);
				result.add(mt.toString());
			}
				
		}
		
		return result.toString();
	}
}

class ModelType{
	public String ip;
	public int type;
	public String name;
	public int index;
	
	public String toString(){
		return "{\"ip\":\""+this.ip+"\",\"type\":\""+this.type+"\",\"name\":\""+this.name+"\",\"index\":\""+index+"\"}";
	}
}