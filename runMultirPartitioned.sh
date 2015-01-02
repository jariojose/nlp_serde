
#input="nigeria_dataset_v04.nlp.in.json.gz"
#output="nigeria_dataset_v04.nlp.out.json.gz"
input=$1
output=$2
cp $input ${input}.bak
for a1 in PERSON ORGANIZATION MISC
do
  for a2 in PERSON ORGANIZATION LOCATION MISC
  do
     mvn scala:run -DmainClass=nlp_serde.annotators.relations.RunPartitionedMultiRAnnotator -DjavaOpts.Xmx=30g -DaddArgs="${a1}|${a2}|${input}|${output}"
     mv $output $input
  done
done
mv $input $output
mv ${input}.bak $input
#mv $output nigeria_dataset_v04.nlp.cw.multir_partitioned.json.gz
