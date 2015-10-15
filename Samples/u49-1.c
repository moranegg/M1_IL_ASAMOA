#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object print;


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp127;
    ILP_Object ilptmp128;
    ILP_Object ilptmp129;
    ilptmp127 = ILP_Integer2ILP (2);
    ilptmp128 = ILP_Integer2ILP (3);
    ilptmp129 = ILP_Integer2ILP (1);

    {
      ILP_Object a1 = ilptmp127;
      ILP_Object b2 = ilptmp128;
      ILP_Object c3 = ilptmp129;
      {
	ILP_Object ilptmp130;
	{
	  ILP_Object ilptmp131;
	  ILP_Object ilptmp132;
	  {
	    ILP_Object ilptmp133;
	    ILP_Object ilptmp134;
	    {
	      ILP_Object ilptmp135;
	      ILP_Object ilptmp136;
	      ilptmp135 = b2;
	      ilptmp136 = b2;
	      ilptmp133 = ILP_Times (ilptmp135, ilptmp136);
	    }
	    {
	      ILP_Object ilptmp137;
	      ILP_Object ilptmp138;
	      ilptmp137 = ILP_Integer2ILP (4);
	      {
		ILP_Object ilptmp139;
		ILP_Object ilptmp140;
		ilptmp139 = a1;
		ilptmp140 = c3;
		ilptmp138 = ILP_Times (ilptmp139, ilptmp140);
	      }
	      ilptmp134 = ILP_Times (ilptmp137, ilptmp138);
	    }
	    ilptmp131 = ILP_Minus (ilptmp133, ilptmp134);
	  }
	  ilptmp132 = ILP_Integer2ILP (0);
	  ilptmp130 = ILP_GreaterThanOrEqual (ilptmp131, ilptmp132);
	}
	if (ILP_isEquivalentToTrue (ilptmp130))
	  {
	    {
	      ILP_Object ilptmp141;
	      ilptmp141 =
		ILP_String2ILP ("discriminant positif: deux racines");
	      return ILP_print (ilptmp141);
	    }

	  }
	else
	  {
	    return ILP_FALSE;

	  }
      }

    }
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
