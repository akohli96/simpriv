package com.simpriv.api.object;

//@Component
public class SnippetAssembler {

//	private EncryptDecrypt encryptDecrypt;
//	private Hasher keyRetrieval;
//	private UserService userService;
//	private SnippetRepository snippetRepository;
//
//	@Inject
//	public SnippetAssembler(EncryptDecrypt encryptDecrypt,Hasher keyRetrieval,UserService userService,SnippetRepository snippetRepository) {
//		this.encryptDecrypt=encryptDecrypt;
//		this.keyRetrieval=keyRetrieval;
//		this.userService=userService;
//		this.snippetRepository=snippetRepository;
//	}
	
//	public Snippet convertToEntity(SnippetDTO dto, String username, String password) {
//		userService.getByPassword(keyRetrieval.hashString(password));
//		String passwordHash = userService.getByUsername(username).getPassword();
//		return new Snippet(encryptDecrypt.encrypt(dto.getMessage(),passwordHash),passwordHash);
//	}
//
//	public SnippetDTO convertToDTO(Snippet snippet, String password) throws SimPrivException {
//		if(!keyRetrieval.hashString(password).equals(snippet.getHash())) {
//			throw new SimPrivException("SnippetAssembler: Incorreect password for message ID " + snippet.getId());
//		}
//		snippetRepository.delete(snippet.getId());
//		return new SnippetDTO(encryptDecrypt.decrypt(snippet.getMessage(), snippet.getHash()));
//	}
}
