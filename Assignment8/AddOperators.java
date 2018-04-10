package assignment8;

import java.util.ArrayList;
import java.util.List;

public class AddOperators {

	public static List<String> addOperators(String num,int target){
		List<String> res=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		dfs(res,sb,num.toCharArray(),0,target,0,0);
		return res;	
	}
	
	private static void dfs(List<String> res, StringBuilder sb, char[] num, int pos, int target, long curr2, long multi) {
		if(pos==num.length) {
			if(target==curr2)res.add(sb.toString());
			return;
		}
		long curr=0;
		for(int i=pos;i<num.length;i++) {
			if(num[pos]=='0' && i!=pos) break;
			curr=10*curr+num[i]-'0';
			int len=sb.length();
			if(pos==0) {
				dfs(res,sb.append(curr),num,i+1,target,curr,curr);
				sb.setLength(len);
			}else {
				dfs(res,sb.append("+").append(curr),num,i+1,target,curr2+curr,curr);
				sb.setLength(len);
				dfs(res,sb.append("-").append(curr),num,i+1,target,curr2-curr,-curr);
				sb.setLength(len);
				dfs(res,sb.append("*").append(curr),num,i+1,target,curr2-multi+multi*curr,multi*curr);
				sb.setLength(len);
			}
		}
	}

	public static void main(String[] args) {
	String example="123";
	int target=6;
	System.out.println(addOperators(example,target));

	}

}
