#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object print;


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp117; 
{ 
  ILP_Object ilptmp118; 
ilptmp118 =  ILP_String2ILP("Un, "); 
ilptmp117 = ILP_print(ilptmp118);
}
{ 
  ILP_Object ilptmp119; 
ilptmp119 =  ILP_String2ILP("deux et "); 
ilptmp117 = ILP_print(ilptmp119);
}
{ 
  ILP_Object ilptmp120; 
ilptmp120 =  ILP_String2ILP("trois."); 
ilptmp117 = ILP_print(ilptmp120);
}
return ilptmp117; 
} 

} 

static ILP_Object ilp_caught_program () {
  struct ILP_catcher* current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if ( 0 == setjmp(new_catcher._jmp_buf) ) {
    ILP_establish_catcher(&new_catcher);
    return ilp_program();
  };
  return ILP_current_exception;
}

int main (int argc, char *argv[]) 
{ 
  ILP_START_GC; 
  ILP_print(ilp_caught_program()); 
  ILP_newline(); 
  return EXIT_SUCCESS; 
} 
