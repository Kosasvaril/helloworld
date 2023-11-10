package org.example;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Regions clientRegion = Regions.US_EAST_1;
        String bucketName = "kls3task2";
        String sourceKey = "src\\main\\java\\org\\example\\test.html";
        String sourceKey2 = "src\\main\\java\\org\\example\\test2.html";
        String sourceKey3 = "src\\main\\java\\org\\example\\test3.html";

        String destinationKey = "test.html";
        String destinationKey2 = "test2.html";
        String destinationKey3 = "test3.html";

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(clientRegion).build();

        try {
            s3.putObject(bucketName, destinationKey, new File(sourceKey));
            s3.putObject(bucketName, destinationKey2, new File(sourceKey2));
            s3.putObject(bucketName, destinationKey3, new File(sourceKey3));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        //Latest version id for a specific file, cli
        //aws s3api list-object-versions --bucket kls3task2 --query 'Versions[?IsLatest].[VersionId]' --prefix test2.html

        //Listing all bucket objects
        //aws s3 ls s3://kls3task2/

        //Listing all bucket object keys
        //aws s3api list-objects --bucket kls3task2 --query "Contents[*].Key"

        //aws s3 cp “C:\Users\Laszlo_Kosasvari\Documents\test.txt” s3://kls3task2/
    }
}