# powerful tool for machine learning 
# in python implement using tensorflow and py torch 

import tensortflow as tf
from tensorflow.keras.datasets import mnist
from tensorflor.keras.models import sequential 

from tensorflow.keras.layers import Dense
from tensorflow.keras.utils import to_categorial 

# load MNIST dataset
(x_train, y_train), (x_test, y_test) = mnist.load_data()

# flatten images
x_train = x_train.reshape(60000, 784)
x_test = x_test.reshape(10000, 784)

# normalize pixel values
x_train = x_train / 255
x_test = x_test / 255 

# convert class vectors to binary class matrices
y_train = to_categorical(y_train, 10)
y_test = to_categorical(y_test, 10)

# create simple neural network model
model = Sequential([
  Dense(128, activation='relu', input_shape=(784,)),
  Dense(10, activation='softmax')
])
# compile model
model.compile(optimizer='adam,
              loss='categorical_crossentropy',
              metrics=['accurac'])
# train model
model.fit(x_train, y_train, epochs=5, batch_size=32)

# evaluate model 
test_loss, test_acc = model.evaluate(x_test, y_test)
print('test acurracy: ', test_acc)
