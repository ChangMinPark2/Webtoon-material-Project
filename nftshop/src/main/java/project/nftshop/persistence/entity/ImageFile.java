package project.nftshop.persistence.entity;

import lombok.*;
import project.nftshop.persistence.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_image_file")
@NoArgsConstructor
@Getter
@AttributeOverride(
        name = "id",
        column = @Column(name = "image_file_id", length = 4)
)
public class ImageFile extends BaseEntity {

    private String fileName;

    private String saveName;

    private String contentType;

    @Builder
    public ImageFile(String fileName,
                     String saveName,
                     String contentType) {
        this.fileName = fileName;
        this.saveName = saveName;
        this.contentType = contentType;
    }
}
