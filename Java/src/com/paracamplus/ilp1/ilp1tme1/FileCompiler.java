package com.paracamplus.ilp1.ilp1tme1;

import java.io.File;

import com.paracamplus.ilp1.compiler.test.CompilerTest;

public class FileCompiler extends CompilerTest{

	public FileCompiler(File file) {
		super(file);
	}
	
	public static void main (String[] argument)
			  throws Exception {
			      if ( argument.length != 1 ) {
			          String msg = "Missing ILP filename!";
			          throw new RuntimeException(msg);
			      }
			      File f = new File(argument[0]);
			      if ( f.exists() && f.canRead() ) {
			          String baseFileName = f.getAbsolutePath();
			          if ( baseFileName.endsWith(".xml") ) {
			              int n = baseFileName.lastIndexOf(".xml");
			              baseFileName = baseFileName.substring(0, n);
			          }
			          FileCompiler tc = new FileCompiler(f);
			          try {
						tc.processFile();
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      }
			  }


}
