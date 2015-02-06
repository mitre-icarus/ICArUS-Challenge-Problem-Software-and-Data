%% SUBJECT TABLE DESIGN - PILOT STUDY 2
% 
% Subject_number: subject number
% Phase_number: experiment phase
% Trial_number: trial number within phase 
% 
% Trial_time: time spent on trial by user, in ms. Subject numbers <= 6 lack
%   times in block 20, due to a GUI bug.
% Trial_score: This score should not be analyzed. This score was generated by the 
%   system after each trial. An average of these scores was presented to the 
%   subject at the end of each block.
%
% Number_probability_sets: the number of probability sets reported in this trial. 
%   Can be 1-3, depending on how many layer presentations occurred.
% Number_groups: the number of groups being tested in this trial. 2-4.
% Max_probs_in_set: Currently always 4.
% 
% --(The remainder are probabilities)--
% They are arranged in blocks, with the block order being:
%   Probs_human: human (subject reported) probabilities
%   Raw_probs_human: human (subject reported) probabilities prior to normalization step
% 
% Each block has 12 entries arranged into Number_probability_sets probability sets 
%   of Max_probs_in_set probabilities.
%   of which the first Number_facilities probabilities will be set.
% Number_probability_sets = 3, corresponding to: 
%   Set 1 = probabilities after 1st layer, 
%   Set 2 = probabilities after 2nd layer, 
%   Set 3 = probabilities after 3rd layer

subject_data_headings = [...
    'Subject_number' 'Phase_number' 'Trial_number'...
    'Surprise' 'Trial_time' 'Group_time' 'Surprise_time' 'Allocation_time' ...
    'Probabilities_score' 'Troop_allocation_score' ...
    'Number_probability_sets' 'Number_groups' 'Max_probs_in_set' ...
    probs_headings('Layer_type',max_probsets) probs_headings('Layer_Surprise',max_probsets) probs_headings('Layer_Surprise_Time',max_probsets) ...
    probs_headings('Center_X',max_probs_in_set) probs_headings('Center_Y',max_probs_in_set) probs_headings('Circle_R',max_probs_in_set) ...
    probs_headings_set('Human_probs',max_probsets,max_probs_in_set) ...
    probs_headings_set('Raw_human_probs',max_probsets,max_probs_in_set) ...
    probs_headings_set('Normative_probs',max_probsets,max_probs_in_set) ...
    probs_headings('Norm_allocation',max_probs_in_set) ...
    probs_headings('Raw_allocation',max_probs_in_set) ...
    ];

% [numbasefields, ...
%     Subject_number_idx, Phase_number_idx, Trial_number_idx, ...
%     Surprise_idx, Trial_time_idx, Group_time_idx, Surprise_time_idx, Allocation_time_idx, ...
%     Probabilities_score_idx, Troop_allocation_score_idx, ...
%     Number_probability_sets_idx, Number_groups_idx, Max_probs_in_set_idx, ...
%     ] = enum;

%Temp addition by Craig to deal with missing enum
numbasefields = 13;
Subject_number_idx = 1; Phase_number_idx = 2; Trial_number_idx = 3;
Surprise_idx = 4; Trial_time_idx = 5; Group_time_idx = 6;
Surprise_time_idx = 7; Allocation_time_idx = 8; Probabilities_score_idx = 9;
Troop_allocation_score_idx = 10; Number_probability_sets_idx = 11;
Number_groups_idx = 12; Max_probs_in_set_idx = 13;
%End temp addition by Craig

layer_type_offset = numbasefields;
layer_surprise_offset = layer_type_offset + max_probsets;
layer_surprise_time_offset = layer_surprise_offset + max_probsets;

circledataoffset = layer_surprise_time_offset + max_probsets;

humanprobsoffset =  circledataoffset + 3*max_probs_in_set;
rawhumanprobsoffset =      humanprobsoffset + max_probsets*max_probs_in_set;
normativeprobsoffset =     rawhumanprobsoffset + max_probsets*max_probs_in_set;
normallocationoffset =    normativeprobsoffset + max_probsets*max_probs_in_set;
rawallocationoffset = normallocationoffset + max_probs_in_set;

enddata =             rawallocationoffset   + max_probs_in_set;
