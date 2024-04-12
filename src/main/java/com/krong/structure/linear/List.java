package com.krong.structure.linear;

/**
 *
 * 자바의 List Interface입니다.
 *
 * @author krongDev
 * @param <E> 리스트 생성 참조 타입
 * @version 1.0
 */
public interface List<E> {
    /**
     * 리스트에 요소를 추가합니다.
     *
     * @param value 리스트에 추가할 요소
     * @return 요소를 추가합니다.
     *         이미 요소가 있을 경우 {@code false} 없을경우 {@code true}를 반환
     */
    boolean add(E value);

    /**
     * 리스트의 특정 위치에 요소를 추가합니다.
     *
     * @param index 리스트에 요소를 추가할 위치
     * @param value 리스트에 추가할 요소
     */
    void add(int index, E value);

    /**
     * 리스트의 특정 위치에 존재하는 요소를 삭제합니다.
     *
     * @param index 리스트의 삭제할 요소의 위치
     * @return 삭제된 요소가 반환됩니다.
     */
    E remove(int index);

    /**
     * 리스트의 특정 요소를 삭제합니다.
     * 동일한 요소가 여러개일 경우 처음 발견되는 요소만 삭제합니다.
     *
     * @param value 리스트에서 삭제할 요소
     * @return 삭제에 성공할 경우 {@code true} 실패할경우 {@code false}를 반환
     */
    boolean remove(Object value);

    /**
     * 리스트의 특정 위치의 요소를 반환합니다.
     *
     * @param index 리스트에서 반환하고 싶은 요소의 위치
     * @retur 리스트의 index 위치에 있는 값을 반환
     */
    E get(int index);

    /**
     * 리스트의 특정 위치에 있는 요소를 새 요소로 대체합니다.
     *
     * @param index 리스트의 대체될 요소의 위치
     * @param value 새로 대체할 요소
     */
    void set(int index, E value);

    /**
     * 리스트에 특정 요소가 존재하는지 확인합니다.
     *
     * @param value 확인할 요소
     * @return 리스트에 해당 요소가 존재한다면 {@code true} 존재하지 않다면 {@code false}를 반환
     */
    boolean contains(Object value);

    /**
     * 리스트에 특정 요소의 위치를 반환합니다.
     *
     * @param value 리스트에서 위치를 찾을 요소
     * @return 리스트에서 해당 요소의 위치를 반환합니다.
     *         여러개가 있을 경우 첫번째 요소의 위치를 반환합니다.
     *         없을 경우 -1을 반환합니다.
     */
    int indexOf(Object value);

    /**
     * 리스트의 요소 개수를 반환합니다.
     *
     * @return 리스트 요소 수 반환
     */
    int size();

    /**
     * 리스트가 비어있는지를 확인합니다.
     *
     * @return 리스트가 비어있으면 {@code true} 비어있지 않으면 {@code false}를 반환합니다.
     */
    boolean isEmpty();

    /**
     * 리스트에 있는 모든 요소를 삭제합니다.
     */
    void clear();
}
