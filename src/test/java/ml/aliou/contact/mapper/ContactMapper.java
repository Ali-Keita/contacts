package ml.aliou.contact.mapper;
@Mapper
public class ContactMapper {
    
    AccountUserEntity toAccountUserEntity(AccountUserDto accountUserDto);
    AccountUserDto toAccountUserDto(AccountUserEntity accountUserEntity);
}
