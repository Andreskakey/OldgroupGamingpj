//#include "vec.h"
#include <iostream>

// The glut library in GL
#ifdef __APPLE__
#  include <GLUT/glut.h>
#else
#  include <GL/glut.h>
#endif


using namespace std;

static int ID = 1; // Object ID.
static float Xangle = 0.0, Yangle = 0.0, Zangle = 0.0; // Angles of rotation set to 0.
static char *objName; // Pointer to object name.
static float SizeOct1 = 5.0;// the size of the object which is the octahedron
static int count = 0;
static int w, h;
//const static typedef vec2 point2;
// the rotation the object from x y z axis.
GLfloat xRotated, yRotated, zRotated;
//The Characters
void writeStrokeString(void *font, char *string)
{
   char *c;

   for (c = string; *c != '\0'; c++) glutStrokeCharacter(font, *c);
}

// writing the name of the object.
void writeObjectName()
{
   glPushMatrix();
   glTranslatef(-4.5, 10.0, -20.0);
   glScalef(0.01, 0.01, 0.01);
   writeStrokeString(GLUT_NORMAL, objName);
   glPopMatrix();
}

// Draw function.
void drawScene()
{
   glClear (GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

   glLoadIdentity();

   // Position of the objects
   gluLookAt(0.0, 3.0, 12.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

   glLineWidth(2.0); //  The frames.

   // Turning the objects.
   glPushMatrix();
   glRotatef(Zangle, 0.0, 0.0, 1.0);
   glRotatef(Yangle, 0.0, 1.0, 0.0);
   glRotatef(Xangle, 1.0, 0.0, 0.0);

   // Drawing the three geometric dimensional object.
   switch(ID)
   {
    case 1:
         glScalef(SizeOct1, SizeOct1, SizeOct1);
         glutSolidOctahedron();
		 objName = "Solid Octahedron";
         break;
    case 2:
         glutSolidSphere(3.0, 14.0, 14.0);
		 objName = "Solid Sphere";
         break;
     // case 3:
         //glutSolidCone(3.0, 8.0, 30, 30);
		 //objName = "Solid Cone";
       //  break;
      default:
		 break;
   }
   glPopMatrix();


   glDisable(GL_LIGHTING);
   glColor3f(2.0, 0.0, 0.0);
   writeObjectName();
   glEnable(GL_LIGHTING);

   glutSwapBuffers();
}

// The initialization.
void setup(void)
{
   // Material vectors.
   float matSpec[] = { 0.0, 1.0, 1.0, 1.0 };
   float matShine[] = { 50.0 };
   float matAmbAndDif[] = {0.0, 0.1, 1.0, 1.0};

   // The vectors property.
   float lightAmb[] = { 0.0, 0.1, 1.0, 1.0 };
   float lightDifAndSpec[] = { 0.0, 0.1, 1.0, 1.0 };
   float lightPos[] = { 0.0, 7.0, 3.0, 0.0 };
   float globAmb[] = { 0.2, 0.2, 0.2, 1.0 };

   //The properties of the objects.
   glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, matSpec);
   glMaterialfv(GL_FRONT_AND_BACK, GL_SHININESS, matShine);
   glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, matAmbAndDif);

   // The light properties in vector.
   glLightfv(GL_LIGHT0, GL_AMBIENT, lightAmb);
   glLightfv(GL_LIGHT0, GL_DIFFUSE, lightDifAndSpec);
   glLightfv(GL_LIGHT0, GL_SPECULAR, lightDifAndSpec);
   glLightfv(GL_LIGHT0, GL_POSITION, lightPos);

   //Ambient light.
   glLightModelfv(GL_LIGHT_MODEL_AMBIENT, globAmb); // Global ambient light.

   glEnable(GL_LIGHTING); // Lighting .
   glEnable(GL_LIGHT0); // Light source.
   glEnable(GL_DEPTH_TEST); // Enable  the depth testing.

   glEnable(GL_NORMALIZE);
   glClearColor(0.0, 0.0, 0.0, 0.0);
}
//The mouse pointer
/*
void myMouse(int button,int state, int x, int y)
{
    if (button == GLUT_RIGHT_BUTTON && state == GLUT_DOWN)
    {
     exit(0);
    }
    if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN)
    {
      [count].x = (float) x / (w/2) - 1.0;
       [count].y = (float) (h-y) /(h/2)- 1.0;
    }
    if (count == 3)
    {
        glutPostRedisplay();
        count =0;
    }

}
*/

//  reshape method.
void resize (int w, int h)
{
   glViewport (0, 0, (GLsizei)w, (GLsizei)h);
   glMatrixMode (GL_PROJECTION);
   glLoadIdentity();
   gluPerspective(60.0, (float)w/(float)h, 2.0, 50.0);
   glMatrixMode(GL_MODELVIEW);
}

// Keyboard input processing routine.
void keyInput(unsigned char key, int x, int y)
{
   switch (key)
   {
      case 27:
        case 'q':
         exit(0);
         break;
      case 'Q':
         exit(0);
         break;
      case 'S':
        SizeOct1+=1.0;
        if (SizeOct1>5.0)
            SizeOct1++;
         glutPostRedisplay();
        break;
         case 's':
        SizeOct1-=1.0;
        if (SizeOct1<5.0)
            SizeOct1--;
         glutPostRedisplay();
        break;
      case 'x':
         Xangle += 5.0;
		 if (Xangle > 360.0) Xangle -= 360.0;
         glutPostRedisplay();
         break;
      case 'X':
         Xangle -= 5.0;
		 if (Xangle < 0.0) Xangle += 360.0;
         glutPostRedisplay();
         break;
      case 'y':
         Yangle += 5.0;
		 if (Yangle > 360.0) Yangle -= 360.0;
         glutPostRedisplay();
         break;
      case 'Y':
         Yangle -= 5.0;
		 if (Yangle < 0.0) Yangle += 360.0;
         glutPostRedisplay();
         break;
      case 'z':
         Zangle += 5.0;
		 if (Zangle > 360.0) Zangle -= 360.0;
         glutPostRedisplay();
         break;
      case 'Z':
         Zangle -= 5.0;
		 if (Zangle < 0.0) Zangle += 360.0;
         glutPostRedisplay();
         break;
      default:
         break;
   }
}
//@ Arrow key
void specialKeyInput(int key, int x, int y)
{
   if(key == GLUT_KEY_DOWN)
   {
      if (ID > 1) ID--;
      else ID = 2;
   }
   if(key == GLUT_KEY_LEFT)
   {
      if (ID > 1) ID--;
      else ID = 2;
   }
   if(key == GLUT_KEY_UP)
   {
      if (ID < 2) ID++;
      else ID = 1;
   }
   if(key == GLUT_KEY_RIGHT)
   {
      if (ID < 2) ID++;
      else ID = 1;
   }

   Xangle = Yangle = Zangle = 0.0;
   glutPostRedisplay();

}

void idleOctahedron(void)
{

     Yangle += 0.01;

    glutSolidOctahedron();
}

static void idle(void)
{
    glutPostRedisplay();
}

const GLfloat light_ambient[]  = { 0.0f, 0.0f, 0.0f, 1.0f };
const GLfloat light_diffuse[]  = { 1.0f, 1.0f, 1.0f, 1.0f };
const GLfloat light_specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
const GLfloat light_position[] = { 2.0f, 5.0f, 5.0f, 0.0f };

const GLfloat mat_ambient[]    = { 0.7f, 0.7f, 0.7f, 1.0f };
const GLfloat mat_diffuse[]    = { 0.8f, 0.8f, 0.8f, 1.0f };
const GLfloat mat_specular[]   = { 1.0f, 1.0f, 1.0f, 1.0f };
const GLfloat high_shininess[] = { 100.0f };



// The Output Window message
void printInteraction(void)
{
   cout << "Creating a three Dimensional Object" << endl;
   cout << "Press the arrow keys to cycle through the objects. " << endl
        << "Press x, X, y, Y, z, Z to turn the objects. " << endl;
   cout << "Press Q q or esc to exit the program" << endl;
}

// Main Program.
int main(int argc, char **argv)
{
   w = 512;
   h = 512;
   printInteraction();
   glutInit(&argc, argv);
   glutInitDisplayMode (GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
   glutInitWindowSize (600, 600);
   glutInitWindowPosition (2,0);
   glutCreateWindow ("Three Dimensional Objects");
   setup();
   glutDisplayFunc(drawScene);
   glutReshapeFunc(resize);
   glutKeyboardFunc(keyInput);
   glutSpecialFunc(specialKeyInput);

/*
     glutIdleFunc(idleOctahedron);
     xRotated = yRotated = zRotated = 1.0;
     xRotated = 1;
     yRotated = 1;

   //glutMouseFunc(myMouse);
*/
    glutMainLoop();
   return 0;
}
