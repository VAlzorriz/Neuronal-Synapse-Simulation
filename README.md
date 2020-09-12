# Neuronal Synapse Simulation

Develop from January 2019 to June 2019 in Madrid, Spain.

## About:

Java application that simulates the neuron electric interaction during the synapsis process, showing the graph of the stimulus in nanoamperes and the graph of the in fire in millivolts of each neuron. The program allows you to connect up to 3 neurons to see how they interact with each other. The application also let you to modify the parameters of each neuron to see the outcome graphs, allowing you to modify the first stimulus parameters, the neuron parameters, and the synapsis parameters. From the first stimulus you can modify stimulus start time(ms), stimulus end time(ms), simulation end time(ms), stimulus intensity(nA) and temporal resolution(ms). From the neuron you can modify resistance(MOh), tau(ms), standby voltage(mV), in fire voltage(mV), reset voltage(mV) and spike voltage(mV). Finally, from the synapsis you can modify spike intensity(mV) and spike duration(ms).

## Team:

This project was developed by two other engineers and my self during the second semester of my first year studing in the European University of Madrid. 

## Development:

To develop this project, first, the team had to research thoroughly how the neurons works and how they connect between each other to be able to simulate the neuron as accurately as possible. Once the team had a good understanding of how the neurons works and what parameters we needed to implement, we started designing the user interface. First, we added only one neuron, implementing the first stimulus parameters and the neuron parameters, so we can test that everything works as intended. For the graphs we use the java plotting libraries that were provided to us. Once the first neuron was completely working, we started to implement the second one. For this we had to calculate the stimulus of the second neuron based on the in-fire outcome of the first neuron and the synapsis parameters of the second one. Then we tested the two neurons together checking that both behave has expected and produce the correct graphs. Finally, we implemented the third neuron, which was relatability easy since we only had to repeat the process of the first and second neurons but with the second and third neurons.


## Languages and tools:

During the development of this project the following lenguages and tools were used:

- <img alt="Eclipse" width="26px" src="https://img1.freepng.es/20180404/ikq/kisspng-eclipse-computer-icons-integrated-development-envi-eclipse-5ac531df4c83e5.0059858415228727993134.jpg"/> Eclipse
- <img alt="Java" width="26px" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/java/java.png"/> Java
- <img alt="Java Swing" width="26px" src="https://lh3.googleusercontent.com/proxy/enr7dZEERObv1YUthIhakFWc6JgnkFy-NEhoXvcfplih503nSzEOWzoTGXFFJGJFTjF7Alg5aEXFvWkjNJEjvFI3YLIZZ4FLqIySNDPnjiNOOs2IsUim4Tr5JpXFE_9a"/> Java Swing

## Images of the proyect:

Neuron 1 Configuration:

<img alt="Neuron 1 Configuration" width="650" src="/img/Neuron1Config.PNG"/>

Neuron 1 Stimulus Graph:

<img alt="Neuron 1 Stimulus Graph" width="650" src="/img/Neuron1StimulusGraph.PNG"/>

Neuron 1 In Fire Graph:

<img alt="Neuron 1 In Fire Graph" width="650" src="/img/Neuron1InFireGraph.PNG"/>

Neuron 2 Configuration:

<img alt="Neuron 2 Configuration" width="650" src="/img/Neuron2Config.PNG"/>

Neuron 2 Stimulus Graph:

<img alt="Neuron 2 Stimulus Graph" width="650" src="/img/Neuron2StimulusGraph.PNG"/>

Neuron 2 In Fire Graph:

<img alt="Neuron 2 In Fire Graph" width="650" src="/img/Neuron2InFireGraph.PNG"/>

Neuron 3 Configuration:

<img alt="Neuron 3 Configuration" width="650" src="/img/Neuron3Config.PNG"/>

Neuron 3 Stimulus Graph:

<img alt="Neuron 3 Stimulus Graph" width="650" src="/img/Neuron3StimulusGraph.PNG"/>

Neuron 3 In Fire Graph:

<img alt="Neuron 3 In Fire Graph" width="650" src="/img/Neuron3InFireGraph.PNG"/>