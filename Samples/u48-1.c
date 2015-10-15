#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object print;


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp124;
    {
      ILP_Object ilptmp125;
      ilptmp125 = ILP_TRUE;
      if (ILP_isEquivalentToTrue (ilptmp125))
	{
	  {
	    ILP_Object ilptmp126;
	    ilptmp126 = ILP_String2ILP ("invisible");
	    ilptmp124 = ILP_print (ilptmp126);
	  }

	}
      else
	{
	  ilptmp124 = ILP_FALSE;

	}
    }
    ilptmp124 = ILP_Integer2ILP (48);
    return ilptmp124;
  }

}

static ILP_Object
ilp_caught_program ()
{
  struct ILP_catcher *current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if (0 == setjmp (new_catcher._jmp_buf))
    {
      ILP_establish_catcher (&new_catcher);
      return ilp_program ();
    };
  return ILP_current_exception;
}

int
main (int argc, char *argv[])
{
  ILP_START_GC;
  ILP_print (ilp_caught_program ());
  ILP_newline ();
  return EXIT_SUCCESS;
}
