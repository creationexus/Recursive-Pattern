package com.arrays;

import java.io.*;

public class ValSeqBlocks {
	private Integer[] addr;
	ValSeqBlocks(){
		this.addr = new Integer[10001];
	}

	private Boolean loadPair(String pair){
		try{
			String[] p = pair.split("-");
			Integer k = p[0].compareTo("BEGIN")==0?0:Integer.parseInt(p[0]);
			Integer v = p[1].compareTo("END")==0?10001:Integer.parseInt(p[1]);
			this.addr[k] = v;
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public Boolean loadChain(String chain){
		try{
			String[] p = chain.split(";");
			for(int i = 0; i < p.length; i++){
				if(!this.loadPair(p[i]))
					return false;
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public Boolean validChain(){
		return this.validChainR(0, addr[0]);
	}

	private Boolean validChainR(Integer n, Integer a){
		try{
			if(a==10001){
				return true;
			}
			if(n==a || a == 0){
				return false;
			}else{
				this.addr[n]=0;
				return this.validChainR(a, this.addr[a]);
			}
		}catch(Exception e){
			return false;
		}
	}


	public void showChain(){
		for(int i = 0;i < 10; i++){
			System.out.println(i+">>"+this.addr[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ValSeqBlocks ch = new ValSeqBlocks();
		String s;
		Boolean r1;
		Boolean r2;
		while ((s = in.readLine()) != null) {
			r1 = ch.loadChain(s);
			r2 = ch.validChain();
			if(!r1||!r2){
				System.out.println("BAD");
			}else{
				System.out.println("GOOD");
			}
			//ch.showChain();
		}
	}
}
