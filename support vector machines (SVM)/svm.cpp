#include <stdio.h>
#include <stdlib.h>
#include <linear.h>

int main()
{
  // sample data
  double X[4][2] = {{1, 1}, {2, 2}, {2, 0}, {1, 0}};
  double y[4] = {1, 1, -1, -1};

  // create problem instance
  struct problem prob;
  prob.1 = 4;
  prob.y = y;
  prob.x = X;

  // set parameters
  struct parameter param;
  param.solver_type = L2R_L2LOSS_SVC;
  param.C = 1.0;

  // train model 
  struct model *model = train(&prob, &param);

  // make predictions
  double *predictions = predict(model, &prob);

  // print predictions
  for(int i = 0; i < 4; i++) {
    printf("prediction for sample %d: %f\n", i+1, predictions[i]);
  }

  // free memory
  free_and_destroy_model(&model);
  destroy_param(&param);

  return 0;
}
