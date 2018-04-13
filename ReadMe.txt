/////////////////////////////////////////////////////////////////////////
                     Problem description
/////////////////////////////////////////////////////////////////////////

Displaying the speech in terms of waveform while recording; both recordings and
displaying must happen simultaneously; There should not be any visible delay in
displaying the waveform while recording just like real time android phone recordings
and all other standard recordings devices like GarageBand;wavesurfer are doing .

////////////////////////////////////////////////////////////////////////
                      Constraints
///////////////////////////////////////////////////////////////////////
We are using JavaFx linechart;
Waveform has been displaying in a scroll pane inside tab

//////////////////////////////////////Notes//////////////////////////////////////

1)In the Capture.txt we have the code for capturing the voice while recording and writting it into the file called record.wav in our pc.
2)In Record.txt we have the code for displaying the waveform while recording.
  a) WE are using a JavaFx tool called linechart ( we have named it as lineChartForRecord ) .
  b) we are using  a filter Algorithm (RamerDouglasPeuckerFilter)to minimise the total no. of samples .
  c) readAudioData() function is inside the Plotwave class as we have added it's code  as different text file.  