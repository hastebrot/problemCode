(1) What we are trying to achieve?
We are trying to display the sound as a dynamic waveform while recording with no visible delay for the naked eyes of the users.

(2) Are their existing products which does the same?
Yes, products like Wavesurfer, Garageband, Android Voice Recording applications and other miscellenous sound recording applications.

(3) What is the problem?
With the existing code <Capture.txt> and <Record.txt>, there are following problems:
-- (3.A.) We can not record different duration files. Especially with sound which spans for more than 1 minute, our system hangs.
-- (3.B.) There is a huge visible delay between the recorded and the plotted sound waveform.
-- (3.C.) Our program is also using a huge amount of RAM (around 1.5 GB or more).

(4) What are we currently doing?
-- We have realized a multithreading process using JavaFx linechart as tool to plot the recorded sound sample
-- The resulting waveform is being displayed in a scroll pane
In terms of code, 
-- (4.A.) As soon as we have pressed "RECORDING", the <Capture.txt> routine kicks up. It records the incoming sound as digital samples in the form of a wave file. This file is called <record.wav>
--(4.B.) Simultaneously <Record.txt> routine kicks up. It starts plotting the <record.wav> by using a Java Fx based line chart tool.

(5) Additinal Information
--(5.A.) We are using  a filter Algorithm (RamerDouglasPeuckerFilter)to minimise the total no. of samples.
--(5.B.) readAudioData() function is inside the Plotwave class as we have added it's code  as different text file.  

(6) Who are we?
We are a group of students and faculty members working on various projects in Indian Institute of Technology Guwahati. Your help will be deeply appreciated and appropriately acknowledged on all our platforms, digital or print.
