package in.helloroomie.domain.ad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Pradeep Arya on 8/8/2015.
 */

@Entity
@Table(name = "IMAGE")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IMAGE_NAME")
    @NotNull
    private String imageName;

    @Column(name = "IMAGE_DATA")
    @NotNull
    private byte[] imageData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

}
