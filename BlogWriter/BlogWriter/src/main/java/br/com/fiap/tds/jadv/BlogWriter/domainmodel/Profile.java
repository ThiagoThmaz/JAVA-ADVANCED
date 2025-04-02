package br.com.fiap.tds.jadv.BlogWriter.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROFILE")
@ToString
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter
    @Setter UUID id;

    @Column(length = 60, nullable = false, insertable = false)
    private @Getter @Setter String bio;

    @Column(length = 60, nullable = false, insertable = false)
    private @Getter @Setter String profilePictureUrl;

    @Column(length = 20, nullable = false, insertable = false)
    private @Getter @Setter String password;

    @OneToOne
    @JoinColumn(name="user_id")
    private @Getter @Setter User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile Profile)) return false;
        return Objects.equals(id, Profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
