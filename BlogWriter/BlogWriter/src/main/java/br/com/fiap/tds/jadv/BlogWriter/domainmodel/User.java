package br.com.fiap.tds.jadv.BlogWriter.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS_")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column(length = 60, nullable = false, insertable = false)
    private @Getter @Setter String name;

    @Column(length = 60, nullable = false, insertable = false)
    private @Getter @Setter String email;

    @Column(length = 20, nullable = false, insertable = false)
    private @Getter @Setter String password;

    @OneToOne( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private @Getter @Setter Profile profile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
